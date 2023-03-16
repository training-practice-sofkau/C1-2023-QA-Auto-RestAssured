package com.sofka.pages;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static com.sofka.setup.ConstantSetup.URLget;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class CommonActionOnPages {

    public void testGetUser(){

        given().contentType(ContentType.JSON);

    }

    public void resquest(int id){
        when().get(String.format(URLget+ id));
        System.out.println();
    }
}




