package com.automation.steps;

import com.automation.pojo.Get_order;
import com.automation.pojo.Response_object;
import com.automation.utils.DataSore;
import com.automation.utils.JsonMapper;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ResponseSteps {



    @Then("verify status code as {int}")
    public void verify_status_code_as(int code) {
        Assert.assertEquals(code , RestAssuredUtils.getResponse().statusCode());
        System.out.println(RestAssuredUtils.getResponse().getBody().asString());
    }

    @Then("verify id is not empty")
    public void verify_id_is_not_empty() {
        Assert.assertFalse(RestAssuredUtils.getResponse().jsonPath().getString("id").isEmpty());
    }

    @And("printing all order details")
    public void printingAllOrderDetails() throws JsonProcessingException {
        List<Get_order> webRecords = new ArrayList<>();
        String result = RestAssuredUtils.getResponse().getBody().asString();

        result = result.replace("]","");
        result = result.replace("[","");

        for(String s:result.split("},")){
            String temp =(s+"}").trim();
            webRecords.add((Get_order) JsonMapper.ResponseClassMapper(temp,"Get_order"));
        }

        webRecords.forEach(System.out::println);
    }


    @Then("compare request and response body")
    public void compareRequestAndResponseBody() {
        Assert.assertEquals(DataSore.createObject.getData().getCpuModel(),DataSore.responseObject.getData().getCpuModel());
        Assert.assertEquals(DataSore.createObject.getName(),DataSore.responseObject.getName());
    }

    @And("verify response message is {string}")
    public void verifyResponseMessageIs(String msg) {
        String reason = RestAssuredUtils.getResponse().getBody().jsonPath().getString("reason");
        reason = reason == null ? " ":reason;
        Assert.assertEquals(msg,reason);
    }
}










