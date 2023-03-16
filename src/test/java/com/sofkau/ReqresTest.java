package com.sofkau;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class ReqresTest {

    @Test
    public void loginTest() {
        String response = RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "   \"email\": \"eve.holt@reqres.in\",\n" +
                        "   \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://regres.in/api/login")
                .then()
                .log()
                .all()
                .extract()
                .asString();
        System.out.println(response);
    }
}
