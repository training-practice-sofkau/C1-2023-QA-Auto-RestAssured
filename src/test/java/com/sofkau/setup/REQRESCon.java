package com.sofkau.setup;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.sofkau.setup.SetUpConsts.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class REQRESCon {

    protected void getToHomePage() {
        given().contentType(ContentType.JSON).get(String.format(REQRES_URL,""));
    }

    protected void getToUsers() {
        given().contentType(ContentType.JSON).get(String.format(REQRES_URL, USERS));
    }

    protected void whenGet(String url) {
        when().get(url);
    }

    protected Response whenPost(String user) {
        return given().header("Content-Type", "application/json")
                .body(user).post(String.format(REQRES_URL, USERS));
    }

    protected void validateBody(String url, String data) {
        get(url).then().assertThat().body(data, hasItems(1, 2, 3, 4, 5, 6));
    }

    protected void validateId(String user) {
        whenPost(user).then().assertThat().body("id", isA(String.class));
    }

    protected void validateCode(String url, int code) {
        get(url).then().assertThat().statusCode(code);
    }

    protected void validateECode(String user, int code) {
        whenPost(user).then().assertThat().statusCode(code);
    }
}