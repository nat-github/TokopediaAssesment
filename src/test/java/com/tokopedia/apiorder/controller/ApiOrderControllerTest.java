package com.tokopedia.apiorder.controller;

import com.tokopedia.apiorder.Constants;
import com.tokopedia.apiorder.model.Order;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static io.restassured.RestAssured.given;

public class ApiOrderControllerTest {
    private RequestSpecification reqSpec ;
    @BeforeClass
    public void reqSetup(){
        reqSpec = new RequestSpecBuilder()
                .setBaseUri(Constants.baseURL)
                .setContentType(ContentType.JSON)
                .build();
    }
    @Test
    public void testOrderstatus(){
        com.tokopedia.apiorder.OrderRequest order = new com.tokopedia.apiorder.OrderRequest();
        order.setOrder_id(172481);
        order.setOrder_description("Tokopedia Order");
        order.setOrder_status("New");
        order.setLast_updated_timestamp(1642321210439L);
        order.setSpecial_order(false);
        Response response = given().spec(reqSpec).and().body(order).when().post(Constants.endPoint);
        Order orderResponse = response.as(Order.class);
        Assert.assertEquals(orderResponse.getOrder_status(),Constants.orderStatus,"Correct order status");
    }

    public void testTimeStamp(){
        com.tokopedia.apiorder.OrderRequest order = new com.tokopedia.apiorder.OrderRequest();
        order.setOrder_id(172481);
        order.setOrder_description("Tokopedia Order");
        order.setOrder_status("New");
        order.setLast_updated_timestamp(1642321210439L);
        order.setSpecial_order(false);
        Response response = given().spec(reqSpec).and().body(order).when().post(Constants.endPoint);
        /*LocalDateTime date =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(1659677907469L), ZoneId.of("UTC"));*/
        Assert.assertEquals(order.getLast_updated_timestamp(),Instant.now().toEpochMilli(),"Corrent timeStamp");
    }
    @Test
    public void testStatusCode(){
        com.tokopedia.apiorder.OrderRequest order = new com.tokopedia.apiorder.OrderRequest();
        order.setOrder_id(172481);
        order.setOrder_description("Tokopedia Order");
        order.setOrder_status("New");
        order.setLast_updated_timestamp(1642321210439L);
        order.setSpecial_order(false);
        Response response = given().spec(reqSpec).and().body(order).when().post(Constants.endPoint);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200,"Successful");
    }
}
