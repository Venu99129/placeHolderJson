package com.automation.utils;

import com.automation.pojo.Create_object;
import com.automation.pojo.Create_order;
import com.automation.pojo.Get_order;
import com.automation.pojo.Response_object;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JsonMapper {

    private static String jsonReader(String filename) throws FileNotFoundException {
        String lines = new Scanner(new FileInputStream("src/test/resources/jsons/"+filename)).useDelimiter("\\z").next();
        return lines;
    }

    public static Object RequestClassMapper(String filename,String className) throws FileNotFoundException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        if(className.contains("order")) {
            Create_order createOrder = objectMapper.readValue(jsonReader(filename), Create_order.class);
            return createOrder;
        } else if (className.contains("object")) {
            Create_object object = objectMapper.readValue(jsonReader(filename),Create_object.class);
            return object;
        }
        return null;
    }

    public static Object ResponseClassMapper(String content, String className) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        if(className.contains("Get_order")) {
            Get_order getOrder = objectMapper.readValue(content, Get_order.class);
            return getOrder;
        }
        else if(className.contains("Response_object")){
            Response_object object = objectMapper.readValue(content,Response_object.class);
            return object;
        }
        return null;
    }

    public static Object jsonToClass(String content, String className) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        if(className.contains("Get_order")) {
            Get_order getOrder = objectMapper.readValue(content, Get_order.class);
            return getOrder;
        }
        else if(className.contains("Response_object")){
            Response_object object = objectMapper.readValue(content,Response_object.class);
            return object;
        }
        else if(className.contains("Create_order")) {
            Create_order createOrder = objectMapper.readValue(content, Create_order.class);
            return createOrder;
        } else if (className.contains("Create_object")) {
            Create_object object = objectMapper.readValue(content,Create_object.class);
            return object;
        }
        return null;
    }
}
