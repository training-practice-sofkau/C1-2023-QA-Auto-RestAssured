package com.sofkau.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static com.sofkau.setup.ConstantSetup.DELETE_SERVICE_URL;
import static com.sofkau.setup.ConstantSetup.DELETE_USER_NOT_FOUND;

public class DeleteService {

    @Test
    public Response deleteTest(){
         Response response = RestAssured
                .given()
                .log().all()
                .when()
                .delete(DELETE_SERVICE_URL);
         return response;

    }

    @Test
    public void assertDeleteTest(){
        deleteTest()
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    public Response deleteTestNotFound(){
        Response response = RestAssured
                .given()
                .log().all()
                .when()
                .delete(DELETE_USER_NOT_FOUND);
        return response;

    }

}
