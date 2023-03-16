package com.sofkau;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class ReqResTests {

    @Test
    public void getUserTest(){

        String response = RestAssured
                .given()
                .log()
                .all()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log()
                .all()
                .extract()
                .asString();
    }
}
