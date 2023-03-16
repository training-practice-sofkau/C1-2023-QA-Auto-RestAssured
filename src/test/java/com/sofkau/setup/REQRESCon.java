package com.sofkau.setup;

import io.restassured.http.ContentType;

import static com.sofkau.setup.SetUpConsts.REQRES_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.hasItem;

public class REQRESCon {

    protected void getToHomePage() {
        given().contentType(ContentType.JSON).get(String.format(REQRES_URL,""));
    }

    protected void getToList(String url) {
        when().get(url);
    }

    protected void validateBody(String url, String schema) {
        get(url).then().assertThat().body("data.id", hasItem(1));
    }

    protected void validateCode(String url) {
        get(url).then().assertThat().statusCode(200);
    }
}
