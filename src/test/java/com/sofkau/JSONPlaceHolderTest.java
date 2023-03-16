package com.sofkau;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class JSONPlaceHolderTest {

    @Test
    public void getUsers() {
        RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("$", hasSize(10));


    }
}
