package com.sofkau.runners;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class testApiList{

    @Test
    public void lotto_resource_returns_200_with_expected_id_and_winners() {

        String body = when().
                get("https://reqres.in/api/users?page=2").
        then().
                extract().body().asString();

        System.out.println(body);
    }
}
