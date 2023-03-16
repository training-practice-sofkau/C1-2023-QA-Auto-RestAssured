package com.sofkau.runners;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class prueba {




    @Test
    public void loginTest() {
        String response = String.valueOf(RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(" \"email\": \"peter@klaven\"")
                .post("https://reqres.in/api/login")
                .then()
                .log()
                .all()
                .statusCode(400));

        //System.out.println(response);

    }

}
