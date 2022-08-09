package stepdef;

import com.tokopedia.apiorder.Constants;
import com.tokopedia.apiorder.model.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.time.Instant;

import static io.restassured.RestAssured.given;

public class OrderTestStepDef {
    private RequestSpecification reqSpec ;
    Order orderResponse;
    Response response;
    @Given("Request specification is setup")
    public void reqSetup(){
        reqSpec = new RequestSpecBuilder()
                .setBaseUri(Constants.baseURL)
                .setContentType(ContentType.JSON)
                .build();
    }
    @Given("User sends the request to Order API {long},{string},{string}")
    public void sendRequest(long orderID,String orderDescription,String orderStatus){
        com.tokopedia.apiorder.OrderRequest order = new com.tokopedia.apiorder.OrderRequest();
        order.setOrder_id(orderID);
        order.setOrder_description(orderDescription);
        order.setOrder_status(orderStatus);
        order.setLast_updated_timestamp(1642321210439L);
        order.setSpecial_order(false);
        response = given().spec(reqSpec).and().body(order).when().post(Constants.endPoint);
    }
    @Then("User verifies the order status")
    public void checkOrderStatus(){
        orderResponse = response.as(Order.class);
        Assert.assertEquals(orderResponse.getOrder_status(),Constants.orderStatus,"Order status validation");
    }
    @Then("User verifies the updatedTimestamp")
    public void checkUpdatedtimestamp(){
        orderResponse = response.as(Order.class);
        /*LocalDateTime date =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(1659677907469L), ZoneId.of("UTC"));*/
        Assert.assertEquals(orderResponse.getLast_updated_timestamp(),Instant.now().toEpochMilli(),"Timestamp validation");
    }
    @Then("User verifies the statusCode {int}")
    public void checkStatusCode(int statusCode){
        orderResponse = response.as(Order.class);
        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode,statusCode,"Status code validation");
    }
    @Then("User verifies the response for any errors")
    public void checkErrorCode(){
        orderResponse = response.as(Order.class);
    }
}
