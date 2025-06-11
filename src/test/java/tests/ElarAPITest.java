package tests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.DriverRequest;
import pojo.DriverResponse;
import utilities.ConfigReader;


import java.util.ArrayList;
import java.util.List;



import static io.restassured.RestAssured.given;

public class ElarAPITest {

    @DataProvider(name = "createNewDriverValidDataAPITest")
    public Object[][] createNewDriverValidDataAPITest(){
        return new Object[][]{
                {"Patelister Harsher", "2026-05-05", "2026-05-05"}

        };
    }

    @DataProvider(name = "createNewDriverInvalidDataAPITest")
    public Object[][] createNewDriverInvalidDataAPITest(){
        return new Object[][]{
                {"Jeniffer Lopez", "2024-06-01", "2025-06-01"},
                {"Jason Momoa","2025-06-01","2024-06-01"},
                {"a","2025-06-01","2025-06-01"},
                {"@#$%","2025-06-01","2025-06-01"}

        };
    }

    int statusCode;
    String id;
    String token="Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiQWNjZXNzIiwiYWxnIjoiSFMyNTYifSwiZXhwIjoxNzQ5MTY0OTk5fQ.C6_hVW5RiJUC3vBpEZp-uIyeaXT10dmhePSL9CtfT8c; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiUmVmcmVzaCIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc0OTE2NDk5OX0.4y6bBOdWjYe7WpS8X7QCsV5GRQnGlD7kxbtI7x_joAo";


    @Test (dataProvider = "createNewDriverValidDataAPITest",groups = {"regression"})
    public void createDriverAPIValidDataTest(String fullName, String DLExpDate, String medExpDate){

        DriverRequest driverRequest=new DriverRequest();
        driverRequest.setFull_name(fullName);
        driverRequest.setLogbook_email("");
        driverRequest.setLogbook_password("");
        driverRequest.setIs_staff(false);
        driverRequest.setIs_local(true);
        driverRequest.setTwic(false);
        driverRequest.setMedical_certification_exp(medExpDate);
        driverRequest.setDriving_license_exp(DLExpDate);
        driverRequest.setContacts_phone(new ArrayList<>());
        driverRequest.setContacts_skype(new ArrayList<>());
        driverRequest.setContacts_viber(new ArrayList<>());
        driverRequest.setContacts_other(new ArrayList<>());
        driverRequest.setContacts_email(new ArrayList<>());

        // SERIALIZATION
        Gson gson=new Gson();
        String driverRequestJson=gson.toJson(driverRequest);

        Response response = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type","application/json")
                .and().header("Cookie",token)
                .and().body(driverRequestJson) // SERIALIZATION -> Java Object -Json
                .when().post("/v3/drivers");
        response.then().log().all();
        statusCode = response.statusCode();

        // take response body and convert to Java object -- DESERIALIZATION\

//        DriverResponse driverResponse = response.body().as(DriverResponse.class); // Json body -> Java Object (DriverResponse)
        DriverResponse driverResponse= gson.fromJson(response.getBody().asString(), DriverResponse.class);

        System.out.println(driverResponse.getId());
        System.out.println(driverResponse.getUuid());

        Assert.assertEquals(200,statusCode);
        Assert.assertEquals(fullName, driverResponse.getFull_name());


    }

    @Test (dataProvider = "createNewDriverInvalidDataAPITest",groups = {"regression"})
    public void createDriverAPIInValidDataTest(String fullName, String DLExpDate, String medExpDate){
        Response response = given().baseUri("https://api.sandbox.elarbridges.com/services/elar-saas/api")
                .and().header("Content-Type","application/json")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiO" +
                        "iJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiQWNjZXNzIiwiYWxnIjoiSFMyNTY" +
                        "ifSwiZXhwIjoxNzQ4NDU4MzUwfQ.kuvKEZFvnbKp9jjs4FkaPQFRw8FGnz8FFeLNoxIGm4I; " +
                        "Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ" +
                        "0eXBlIjoiUmVmcmVzaCIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc0ODQ1ODM1MH0." +
                        "GaM8JZwSniYeslI4iRu9ZMhqQ14Xfx-210pyNR12agg")
                .and().body("{\n" +
                        "  \"full_name\": \""+fullName+"\",\n" +
                        "  \"logbook_email\": \"\",\n" +
                        "  \"logbook_password\": \"\",\n" +
                        "  \"is_staff\": false,\n" +
                        "  \"is_local\": true,\n" +
                        "  \"local_state\": \"GA\",\n" +
                        "  \"twic\": false,\n" +
                        "  \"driving_license_exp\": \""+DLExpDate+"\",\n" +
                        "  \"medical_certification_exp\": \""+medExpDate+"\",\n" +
                        "  \"contacts_phone\": [],\n" +
                        "  \"contacts_skype\": [],\n" +
                        "  \"contacts_viber\": [],\n" +
                        "  \"contacts_other\": []\n" +
                        "}")
                .when().post("/v3/drivers");
        response.then().log().all();
        statusCode = response.statusCode();

        Assert.assertEquals(400,statusCode);

    }

    @DataProvider(name = "sizeData")
    public Object[][] sizeData(){
        return new Object [][]{
                {1},
                {5},
                {10},
                {50}
        };
    }

    @Test(dataProvider = "sizeData",groups = {"regression"})
    public void getDriverApiWithSize(int size){
        Response response = given().baseUri(ConfigReader.getProperty("ElarAppAPIBaseURL"))
                .and().header("Content-Type","application/json")
                .and().queryParam("order_by","id")
                .and().queryParam("size",size)
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiQWNjZXNzIiwiYWxnIjoiSFMyNTYifSwiZXhwIjoxNzQ5MTY0OTk5fQ.C6_hVW5RiJUC3vBpEZp-uIyeaXT10dmhePSL9CtfT8c; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiUmVmcmVzaCIsImFsZyI6IkhTMjU2In0sImV4cCI6MTc0OTE2NDk5OX0.4y6bBOdWjYe7WpS8X7QCsV5GRQnGlD7kxbtI7x_joAo")
                .when().get("/v3/drivers");
        response.then().log().all();
        List<Integer> driverIds=response.body().jsonPath().getList("items.id");
        System.out.println(driverIds);

        Assert.assertEquals(driverIds.size(), size);
    }


    @DataProvider(name = "isStaffData")
    public Object[][] isStaffData(){
        return new Object [][]{
                {"true"},
                {"false"}
        };
    }

    @Test(dataProvider = "isStaffData",groups = {"regression"})
    public void getDriverApiCallStaffTrue(String isStaff){
        Response response = given().baseUri(ConfigReader.getProperty("ElarAppAPIBaseURL"))
                .and().header("Content-Type","application/json")
                .and().queryParam("is_staff",isStaff)
                .and().queryParam("order_by","id")
                .and().queryParam("size","5")
                .and().header("Cookie","Access=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                        "eyJzdWIiOiJhcnNsYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiQWNjZXNzIiwiYW" +
                        "xnIjoiSFMyNTYifSwiZXhwIjoxNzQ5MTY0OTk5fQ.C6_hVW5RiJUC3vBpEZp-uIyeaXT10d" +
                        "mhePSL9CtfT8c; Refresh=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhcnN" +
                        "sYW5AbWluZHRlayIsImhlYWRlciI6eyJ0eXBlIjoiUmVmcmVzaCIsImFsZyI6IkhTMjU2In0sImV4c" +
                        "CI6MTc0OTE2NDk5OX0.4y6bBOdWjYe7WpS8X7QCsV5GRQnGlD7kxbtI7x_joAo")
                .when().get("/v3/drivers");
        response.then().log().all();
        List<Boolean> driverStatus=response.body().jsonPath().getList("items.is_staff");
        System.out.println(driverStatus);

        for(Boolean status: driverStatus) {
            if(isStaff.equals("true")) Assert.assertTrue(status);
            else if(isStaff.equals("false")) Assert.assertFalse(status);
        }
    }
}
