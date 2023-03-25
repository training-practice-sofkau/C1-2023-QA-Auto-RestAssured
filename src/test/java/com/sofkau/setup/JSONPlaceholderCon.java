package com.sofkau.setup;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.sofkau.setup.SetUpConsts.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class JSONPlaceholderCon {

    protected void getToHomePage() {
        given().contentType(ContentType.JSON).get(String.format(JSONPLACEHOLDER_URL,""));
    }

    protected Response whenPost(String resource) {
        return given().header("Content-Type", "application/json; charset=UTF-8")
                .body(resource).post(String.format(JSONPLACEHOLDER_URL, CREATE_TODO));
    }

    protected Response whenPut(String resource) {
        return given().header("Content-Type", "application/json; charset=UTF-8")
                .body(resource).put(String.format(JSONPLACEHOLDER_URL, UPDATE_POST));
    }

    protected void validateTitle(String resource, String data) {
        whenPost(resource).then().assertThat().body(data, equalTo("Hi!"));
    }

    protected void validateNewTitle(String resource, String data) {
        whenPut(resource).then().assertThat().body(data, equalTo("HI"));
    }
}