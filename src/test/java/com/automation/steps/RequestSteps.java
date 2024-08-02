package com.automation.steps;

import com.automation.pojo.Response_object;
import com.automation.pojo.TokenBody;
import com.automation.utils.DataSore;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;

public class RequestSteps {

    @Given("set end point as {string}")
    public void set_end_point_as(String endpoint) {
        RestAssuredUtils.setEndPoint(endpoint);
    }

    @Given("set Header as {string} to {string}")
    public void set_header_as_to(String key, String value) {
        RestAssuredUtils.setHeader(key,value);
    }

    @Given("set body as json file {string}")
    public void set_body_as_json_file(String filename) throws FileNotFoundException, JsonProcessingException {
        RestAssuredUtils.setBody(filename);
    }

    @When("call the post method")
    public void call_the_post_method() {
        RestAssuredUtils.post();
    }


    @And("set body is empty")
    public void setBodyIsEmpty() throws FileNotFoundException, JsonProcessingException {
        RestAssuredUtils.setBodyEmpty();
    }

    @Then("call get method")
    public void callGetMethod() throws JsonProcessingException {
        RestAssuredUtils.get();
        DataSore.responseObject = (Response_object) RestAssuredUtils.ResponseIntoClass("Response_object");
    }

    @And("set request body from the file with username {string} and password {string}")
    public void setRequestBodyFromTheFileWithUsernameAndPassword( String username, String password) {
        TokenBody tokenBody = new TokenBody();
        tokenBody.setUsername(username);
        tokenBody.setPassword(password);
        RestAssuredUtils.setBody(tokenBody);
    }
}
