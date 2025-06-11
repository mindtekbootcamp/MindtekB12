package tests;

import dataproviders.CreateDriverDataProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.CreateAddressAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateAddress {

    String token = "Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiQWNjZXNzIiwiYWxnIjoiSFMyNTYifSwiZXhwIjoxNzQ5NzY5Mjg4fQ.JPirV9RysZMIaSuwgQM3ikoUk8cno9wYpxPViFjN-Jo; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiUmVmcmVzaCIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc0OTc2OTI4OH0.o5FgPoCdrFHQVhQS7pc9yZiIZ-BrRzbAosN8TEBn7Hk";
    int statuscode;

    @Test(dataProvider = "createNewAddress", groups = {"regression"}, dataProviderClass = CreateDriverDataProvider.class)
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

    @Test(dataProvider = "addressSizeData", groups = {"regression"}, dataProviderClass = CreateDriverDataProvider.class)
    public void getAddressAPITest(int size, String name) {
        Response response = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type", "application/json")
                .and().queryParam("order_by", name)
                .and().queryParam("size", size)
                .and().header("Cookie", token)
                .when().get("/v3/addresses");
        response.then().log().all();
        List<Integer> driverIDs = response.body().jsonPath().getList("items.id");
        if (name.equals("id")) {
            List<Integer> expectedDriverIDs = new ArrayList<>(driverIDs);
            Collections.sort(expectedDriverIDs);
            Assert.assertEquals(expectedDriverIDs, driverIDs);
        } else if (name.equals("address")) {
            List<String> driverAddresses = response.body().jsonPath().getList("items.address");
            List<String> expectedDriverAddresses = new ArrayList<>(driverAddresses);
            Collections.sort(expectedDriverAddresses);
            Assert.assertEquals(expectedDriverAddresses, driverAddresses);
        }
        System.out.println(driverIDs);
        int totalNumberOfAddresses = Integer.parseInt(response.body().jsonPath().getString("total"));
        if (totalNumberOfAddresses >= size) {
            Assert.assertEquals(driverIDs.size(), size);
        } else if (totalNumberOfAddresses < size) {
            Assert.assertEquals(driverIDs.size(), totalNumberOfAddresses);
        }
    }

    @Test(dataProvider = "createInvalidNewAddress", groups = {"regression"}, dataProviderClass = CreateDriverDataProvider.class)
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

    @Test(dataProvider = "validateSizeData", groups = {"regression"}, dataProviderClass = CreateDriverDataProvider.class)
    public void validateSizeData(int size, String expectedErrorMessage) {

        Response response = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().queryParam("size", size)
                .and().header("Content-Type", "application/json")
                .and().header("Accept", "application/json")
                .and().header("Cookie", token)
                .and().log().all()
                .when().get("/v3/addresses");
        response.then().log().all();
        response.then().statusCode(422);
        String errorMessage = response.body().jsonPath().getString("detail[0].msg");
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }
}