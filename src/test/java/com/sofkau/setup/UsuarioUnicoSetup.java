package com.sofkau.setup;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static com.sofkau.util.log4j.LOG4J_PROPERTIES_FILE_PATH;

public class UsuarioUnicoSetup {

    private static final String BASE_URI = "https://reqres.in";
    private static final String BASE_PATH = "/api";
    protected static final String LOGIN_RESOURCE1 = "/user/2";

    protected static final String LOGIN_RESOURCE2 = "/user/50";

    protected void generalSetup() {
        setUpLog4j2();
        setUpBases();
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }


    private void setUpBases() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;

    }


}
