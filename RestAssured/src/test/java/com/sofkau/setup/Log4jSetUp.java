package com.sofkau.setup;

import org.apache.log4j.PropertyConfigurator;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;


import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class Log4jSetUp {
    protected void generalSetUp(){
        setUplog4j();
    }


    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
