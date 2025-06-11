package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pojo.BookingCreateResponse;
import pojo.BookingDates;
import pojo.BookingPartialUpdateRequest;
import pojo.BookingRequest;

import java.awt.print.Book;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class BookingApiTest {

    @Test(groups = {"regression"})
    public void partialUpdateBookingApiTest(){

        /*
        1.Create booking
        2. Partial update booking
        3. Get booking and validate partial update is worked
         */

        //1. Create a book api
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setFirstname("John");
        bookingRequest.setLastname("Doe");
        bookingRequest.setTotalprice(111);
        bookingRequest.setDepositpaid(true);
        bookingRequest.setAdditionalneeds("Breakfast");

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2025-07-01");
        bookingDates.setCheckout("2025-08-01");

        bookingRequest.setBookingdates(bookingDates);

        Response response=given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Content-Type","application/json")
                .and().body(bookingRequest)
                .and().log().all()
                .when().post("/booking");

        response.then().log().all();
        response.then().statusCode(200);

        BookingCreateResponse bookingCreateResponse = response.getBody().as(BookingCreateResponse.class);
        int bookingId = bookingCreateResponse.getBookingid();

        // 2. Partial Update booking

        BookingPartialUpdateRequest partialUpdateRequest = new BookingPartialUpdateRequest();
        partialUpdateRequest.setFirstname("Johnny");
        partialUpdateRequest.setLastname("Doe");
        partialUpdateRequest.setAdditionalneeds("Bike");

        Response patchResponse = given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Content-Type","application/json")
                .and().header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().body(partialUpdateRequest)
                .when().patch("/booking/"+bookingId);
        patchResponse.then().log().all();
        patchResponse.then().statusCode(200);

        // 3. Get created booking

        Response getResponse = given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Accept","application/json")
                .when().get("/booking/"+bookingId);
        getResponse.then().log().all();
        getResponse.then().statusCode(200);


        // Validation steps

        getResponse.then().body("firstname", Matchers.equalTo("Johnny"))
                .body("additionalneeds",Matchers.equalTo("Bike"))
                .body("bookingdates.checkin",Matchers.equalTo("2025-07-01"));



    }

    @Test (groups = {"regression"})
    public void deleteBookingAPITest(){
        /*
        1. Create bookig
        2.delete booking
        3. get booking and validate 404 status code
         */

        // 1. create booking
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setFirstname("John");
        bookingRequest.setLastname("Doe");
        bookingRequest.setTotalprice(111);
        bookingRequest.setDepositpaid(true);
        bookingRequest.setAdditionalneeds("Breakfast");

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2025-07-01");
        bookingDates.setCheckout("2025-08-01");

        bookingRequest.setBookingdates(bookingDates);

        Response response=given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Content-Type","application/json")
                .and().body(bookingRequest)
                .and().log().all()
                .when().post("/booking");

        response.then().log().all();
        response.then().statusCode(200);

        BookingCreateResponse bookingCreateResponse = response.getBody().as(BookingCreateResponse.class);
        int bookingId = bookingCreateResponse.getBookingid();

        // 2. delete booking

        Response deleteResponse = given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .and().header("Cookie","token=<f43bd5759f84157>")
                .when().delete("/booking/"+bookingId);
        deleteResponse.then().log().all();
        deleteResponse.then().statusCode(201);

        // 3. get booking and validate 404 status code
        Response getResponse = given().baseUri("https://restful-booker.herokuapp.com")
                .and().header("Accept","application/json")
                .when().get("/booking/"+bookingId);
        getResponse.then().log().all();
        getResponse.then().statusCode(404);
    }
}
