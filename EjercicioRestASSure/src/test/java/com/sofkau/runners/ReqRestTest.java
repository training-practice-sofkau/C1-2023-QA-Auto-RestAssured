//package com.sofkau.runners;
//
//import io.restassured.RestAssured;
//import org.junit.Test;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.hasItems;
//
//public class ReqRestTest {
//
//    @Test
//    public void
//    getUsersOfPage() {
//
//        String pageNumber = "2";
//        RestAssured.baseURI = "https://reqres.in/api";
//        String body = RestAssured.given().log().all().when().get("users?page=1")
//                .then().log().all().extract().body().asString();
//
//        System.out.println(body);
//    }
//
//
//}
