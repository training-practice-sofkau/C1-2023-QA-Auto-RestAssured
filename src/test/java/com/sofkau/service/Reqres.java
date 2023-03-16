package com.sofkau.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class Reqres {
    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://reqres.in";

        String response = RestAssured
                .given()
                    .log()
                    .all()
                .contentType(ContentType.JSON)
                .get("/api/users?page=2")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .asString();

        System.out.println(response);
    }

}
