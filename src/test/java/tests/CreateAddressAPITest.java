package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.ElarAppCreateAddressAPI;
import utilities.ConfigReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;


public class CreateAddressAPITest {

    int statusCode;
    String token="Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
            "eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0" +
            "eXBlIjoiQWNjZXNzIiwiYWxnIjoiSFMyNTYifSwiZXhwIjox" +
            "NzQ5NzY5Mjg4fQ.JPirV9RysZMIaSuwgQM3ikoUk8cno9wYpx" +
            "PViFjN-Jo; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6Ikp" +
            "XVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI" +
            "6eyJ0eXBlIjoiUmVmcmVzaCIsImFsZyI6IkhTMjU2In0sImV4c" +
            "CI6MTc0OTc2OTI4OH0.o5FgPoCdrFHQVhQS7pc9yZiIZ-BrRzb" +
            "AosN8TEBn7Hk";

    @DataProvider(name="createAddressWithValidCredentials")
    public Object[][] createAddressWithValidCredentials(){
        return new Object[][]{
                {"123 John st","Chicago","IL","60659","ABC"},
                {"456 Momoa st","Atlanta","GA","30009","LMN"}
        };
    }


    @Test(dataProvider = "createAddressWithValidCredentials")
    public void createAddressWithValidCredentialsAPITest(String street, String city, String state, String zipCode, String name){

        ElarAppCreateAddressAPI elarAppCreateAddressAPI = new ElarAppCreateAddressAPI();
        elarAppCreateAddressAPI.setAddress(street);
        elarAppCreateAddressAPI.setCity(city);
        elarAppCreateAddressAPI.setState(state);
        elarAppCreateAddressAPI.setZipCode(zipCode);
        elarAppCreateAddressAPI.setName(name);

        Response response=given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type","application/json")
                .and().header("Accept","application/json")
                .and().header("Cookie",token)
                .and().body(elarAppCreateAddressAPI)
                .when().post("/v3/addresses");
        response.then().log().all();
        statusCode = response.statusCode();

        Assert.assertEquals(200,statusCode);
        System.out.println(statusCode);

    }

    @DataProvider(name="createAddressWithInvalidCredentials")
    public Object[][] createAddressWithInvalidData(){
        return new Object[][]{
                {"123 John st","Chicago","Illinois","60659","ABC"},
                {"456 Momoa st","Atlanta","GA","606590","LMN"}
        };
    }

    @Test(dataProvider = "createAddressWithInvalidCredentials")
    public void createAddressWithInvalidCredentials(String street, String city, String state, String zipCode, String name){

        ElarAppCreateAddressAPI elarAppCreateAddressAPI = new ElarAppCreateAddressAPI();
        elarAppCreateAddressAPI.setAddress(street);
        elarAppCreateAddressAPI.setCity(city);
        elarAppCreateAddressAPI.setState(state);
        elarAppCreateAddressAPI.setZipCode(zipCode);
        elarAppCreateAddressAPI.setName(name);

        Response response=given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type","application/json")
                .and().header("Accept","application/json")
                .and().header("Cookie",token)
                .and().body(elarAppCreateAddressAPI)
                .and().log().all()
                .when().post("/v3/addresses");
        response.then().log().all();
        statusCode = response.statusCode();

        Assert.assertEquals(422,statusCode);
        System.out.println(statusCode);

    }




    @DataProvider(name = "addressSizeData")
    public Object[][] addressSizeData(){
        return new Object [][]{
                {1,"id"},
                {100,"address"},
                {99,"city"},
                {50,"state"},
                {5,"zip_code"},
                {10,"name"}
        };
    }


    @Test(dataProvider = "addressSizeData")
    public void getAddressAPITest(int size,String name){
        Response response = given().baseUri(ConfigReader.getProperty("ElarAppAPIBaseURL"))
                .and().header("Content-Type","application/json")
                .and().queryParam("order_by",name)
                .and().queryParam("size",size)
                .and().header("Cookie",token)
                .when().get("/v3/addresses");
        response.then().log().all();
        List<Integer> addressIds=response.body().jsonPath().getList("items.id");
        if (name.equals("id")){
            List<Integer> expectedAddressId = new ArrayList<>(addressIds);
            Collections.sort(expectedAddressId);
            Assert.assertEquals(expectedAddressId,addressIds);
        } else if (name.equals("address")) {
            List<String> addresses = response.body().jsonPath().getList("items.address");
            List<String> expectedAddresses = new ArrayList<>(addresses);
            Collections.sort(expectedAddresses);
            Assert.assertEquals(expectedAddresses,addresses);
        }

        System.out.println(addressIds);

        int totalNumOfAddresses = Integer.parseInt(response.body().jsonPath().getString("total"));
        if (totalNumOfAddresses>size){
            Assert.assertEquals(addressIds.size(),size);
        }else if (totalNumOfAddresses<size){
            Assert.assertEquals(addressIds.size(),totalNumOfAddresses);
        }

//        Assert.assertEquals(addressIds.size(), size);
//        Assert.assertEquals(sortedAddressCity,actualAddressCity);

    }
}
