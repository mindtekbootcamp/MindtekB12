package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.CreateAddressAPI;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateAddress {

    String token = "Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiQWNjZXNzIiwiYWxnIjoiSFMyNTYifSwiZXhwIjoxNzQ5NjA0NTA5fQ.1vzEi1E8mzG6GioYljQH0wX_c7rs9le1hpHBObxMZDQ; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiUmVmcmVzaCIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc0OTYwNDUwOX0.Dnm0_gHTueVjQZZKEUtcHlilDBGZowDqkOO13ECH62Q";
    int statuscode;

    @DataProvider(name = "createNewAddress")
    public Object[][] createNewAddress() {
        return new Object[][]{
                {"354 abc", "Chicago", "IL", "23987", "Xyz"},
                {"122 hyg", "Forest Park", "IL", "67415", "Plur"}
        };
    }


    @Test(dataProvider = "createNewAddress")
    public void createAddressWithValidCredentialsAPI(String street, String city, String state, String zipcode, String name) {

        CreateAddressAPI createAddressAPI = new CreateAddressAPI();
        createAddressAPI.setAddress(street);
        createAddressAPI.setCity(city);
        createAddressAPI.setState(state);
        createAddressAPI.setZip_code(zipcode);
        createAddressAPI.setName(name);


        Response response = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type", "application/json")
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().body(createAddressAPI)
                .when().post("/v3/addresses");
        response.then().log().all();
        statuscode = response.statusCode();

        Assert.assertEquals(200, statuscode);
    }


    @DataProvider(name = "addressSizeData")
    public Object[][] addressSizeData() {
        return new Object[][]{
                {1, "id"},
                {50, "address"},
                {50, "city"},
                {50, "state"},
                {5, "zip_code"},
                {10, "name"}
        };
    }

    @Test(dataProvider = "addressSizeData")
    public void getAddressAPITest(int size, String name) {
        Response response = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type", "application/json")
                .and().queryParam("order_by", name)
                .and().queryParam("size", size)
                .and().header("Cookie", token)
                .when().get("/v3/addresses");
        response.then().log().all();
        List<Integer> driverIDs = response.body().jsonPath().getList("items.id");
        System.out.println(driverIDs);

        Assert.assertEquals(driverIDs.size(), size);

    }

    @DataProvider(name = "createInvalidNewAddress")
    public Object[][] createInvalidNewAddress() {
        return new Object[][]{
                {"354 abc", "Chicago", "Il", "253987", "Xyz"},
                {"122 h@g", "Forest Park", "Illinois", "60745", "P!ur"}
        };
    }

    @Test(dataProvider = "createInvalidNewAddress")
    public void createInvalidNewAddress(String street, String city, String state, String zipcode, String name) {

        CreateAddressAPI createAddressAPI = new CreateAddressAPI();
        createAddressAPI.setAddress(street);
        createAddressAPI.setCity(city);
        createAddressAPI.setState(state);
        createAddressAPI.setZip_code(zipcode);
        createAddressAPI.setName(name);


        Response response = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type", "application/json")
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().body(createAddressAPI)
                .when().post("/v3/addresses");
        response.then().log().all();
        statuscode = response.statusCode();

        Assert.assertEquals(422, statuscode);

    }

}