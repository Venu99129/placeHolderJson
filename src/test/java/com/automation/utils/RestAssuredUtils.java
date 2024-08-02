package com.automation.utils;


import com.automation.pojo.Create_object;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;

public class RestAssuredUtils {

    static RequestSpecification requestSpecification = RestAssured.given();
    static Response response;
    static String endpoint;

    public static void setEndPoint(String endpoint){
        RestAssuredUtils.endpoint = endpoint;
    }

    public static void post(){

        if(endpoint.contains("post")) {
            requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
            requestSpecification.log().all();
            response = requestSpecification.post(endpoint);
            DataSore.id = response.jsonPath().getString("id");
        } else if (endpoint.contains("objects")) {
            requestSpecification.baseUri("https://api.restful-api.dev");
            requestSpecification.log().all();
            response = requestSpecification.post(endpoint);
            DataSore.id = response.jsonPath().getString("id");
        }else if (endpoint.contains("auth")) {
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.log().all();
            response = requestSpecification.post(endpoint);
        }
    }

    public static void setBody(String filename) throws FileNotFoundException, JsonProcessingException {
        if(endpoint.contains("post")) {
            requestSpecification.body(JsonMapper.RequestClassMapper(filename, "Create_order"));
        }
        else if(endpoint.contains("objects")){
            DataSore.createObject = (Create_object) JsonMapper.RequestClassMapper(filename,"Create_object");
            requestSpecification.body(DataSore.createObject);

        }
    }

    public static void setBody(Object obj){
        requestSpecification.body(obj);
    }

    public static Object ResponseIntoClass(String expectedClassName) throws JsonProcessingException {

        return JsonMapper.ResponseClassMapper(RestAssuredUtils.getResponse().getBody().asString(),expectedClassName);
    }

    public static void setHeader(String key,String value){
        requestSpecification.header(key,value);
    }

    public static Response getResponse(){
        return response;
    }



    public static void get(){
        if(endpoint.contains("@id")) {
            endpoint = endpoint.replace("@id",DataSore.id);
            response = requestSpecification.get(endpoint);
        }
        else response = requestSpecification.get(endpoint);
    }

    public static void setBodyEmpty() {
        requestSpecification.body("{}");
    }
}
