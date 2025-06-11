package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.ElarAppCreateAddressAPI;
import utilities.ConfigReader;

import java.util.List;

import static io.restassured.RestAssured.given;


public class CreateAddressAPITest {

    int statusCode;
    String token="Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
            "eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBl" +
            "IjoiQWNjZXNzIiwiYWxnIjoiSFMyNTYifSwiZXhwIjoxNzQ5NjA0NT" +
            "A5fQ.1vzEi1E8mzG6GioYljQH0wX_c7rs9le1hpHBObxMZDQ; " +
            "Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiO" +
            "iJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiUmVmcmVzaC" +
            "IsImFsZyI6IkhTMjU2In0sImV4cCI6MTc0OTYwNDUwOX0.Dnm0_gHTue" +
            "VjQZZKEUtcHlilDBGZowDqkOO13ECH62Q";

    @DataProvider(name="createAddressWithValidCredentials")
    public Object[][] createAddressWithValidCredentials(){
        return new Object[][]{
                {"123 John st","Chicago","IL","60659","ABC"},
                {"456 Momoa st","Atlanta","GA","30009","LMN"}
        };
    }

    /*
    {
  "address": "123 abc",
  "city": "Chicago",
  "state": "IL",
  "zip_code": "60656",
  "name": "Abc"

  Content-Type: application/json
Accept: application/json
Cookie: token
}
     */

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

    @DataProvider(name = "addressSizeData")
    public Object[][] addressSizeData(){
        return new Object [][]{
                {1,"id"},
                {50,"address"},
                {50,"city"},
                {50,"state"},
                {5,"zip_code"},
                {10,"name"}
        };
    }
    /*
    id/address/city/state/zip_code/name
     */

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

        System.out.println(addressIds);

        Assert.assertEquals(addressIds.size(), size);

    }
}
