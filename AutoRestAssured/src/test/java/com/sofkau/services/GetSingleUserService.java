package com.sofkau.services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.containsString;

import static com.sofkau.setup.ConstantSetup.DELETE_SERVICE_URL;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserService {
    @Test
    public Response getSingleUser(){
        Response response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .get(DELETE_SERVICE_URL);

        return response;

    }

    @Test
    public void assertSingleUser(){
        getSingleUser()
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }
}
