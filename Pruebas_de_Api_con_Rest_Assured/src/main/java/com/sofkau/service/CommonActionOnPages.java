package com.sofkau.service;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommonActionOnPages {
    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    public void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public void clearText(By locator){
        driver.findElement(locator).clear();
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
    protected void pressEnter(By locator) {

        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

}