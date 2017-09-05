package com.selenium.training.pom.pages;

import org.openqa.selenium.By;

/**
 * Created by Aby on 5/09/2017.
 */
public class HotelPage extends BasePage{
    protected By destinationTextBox = By.name("from");
    
    public void EnterDestination(String destination){
        driver.findElement(destinationTextBox).sendKeys(destination);
    }
}
