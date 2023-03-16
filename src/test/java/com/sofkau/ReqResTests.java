package com.sofkau;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;

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

    @Test
    public void getUTest(){

        String response2 = RestAssured
                .given()
                .queryParam("per_page", 4)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.size()", lessThanOrEqualTo(4))
                .extract()
                .asString();


        System.out.println(response2);
    }

    @Test
    public void postUserTest(){

        String response = RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        " \"email\": \"eve.holt@reqres.in\", \n" +
                        " \"password\": \"pistol\" \n" +
                        "}")
                .post("https://reqres.in/api/register")
                .then()
                .log()
                .all()
                .extract()
                .asString();

    }

    @Test
    public void postPasswordTest(){

        String response = RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        " \"email\": \"eve.holt@reqres.in\", \n" +
                        " \"password\": \"\" \n" +
                        "}")
                .post("https://reqres.in/api/register")
                .then()
                .body("error", equalTo("Missing password"))
                .log()
                .all()
                .extract()
                .asString();

    }


}
