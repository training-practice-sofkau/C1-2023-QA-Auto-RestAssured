package com.sofkau.setup;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;
import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.REQRES_PATH;
import static com.sofkau.setup.ConstantSetup.REQRES_URL;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    public void generalSetup(){
        setUplog4j();
        setUpBases();
    }
    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value()+LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
    private void setUpBases(){
        RestAssured.baseURI=REQRES_URL;
        RestAssured.basePath=REQRES_PATH;
    }
}
