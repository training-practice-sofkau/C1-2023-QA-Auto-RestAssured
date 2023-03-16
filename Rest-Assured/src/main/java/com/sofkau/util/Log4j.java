package com.sofkau.util;
public enum Log4j {
    LOG4J_PROPERTIES_FILE_PATH("/src/test/resources/log4j.properties");
    private final String value;
    Log4j(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
