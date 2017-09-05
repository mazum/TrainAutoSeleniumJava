package com.selenium.training.pom.pages;

import org.openqa.selenium.By;

/**
 * Created by Aby on 5/09/2017.
 */
public class HomePage extends BasePage {
    protected By fromTextBox= By.name("origin");
    protected By toTextBox= By.name("destination");

    public void EnterOrigin(String origin){
        driver.findElement(fromTextBox).sendKeys(origin);
    }

    public void EnterDestination(String destination){
        driver.findElement(toTextBox).sendKeys(destination);
    }
}
