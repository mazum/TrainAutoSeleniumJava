package com.selenium.training.pom.pages;

import org.openqa.selenium.By;

/**
 * Created by Aby on 5/09/2017.
 */
public class HomePage extends BasePage {
    protected By fromTextBox= By.name("origin");
    protected By toTextBox= By.name("destination");
    protected By departOnDate = By.id("DepartDate");
    protected By dateMonthYear=By.cssSelector("div.title");
    protected By nextMonthLink=By.cssSelector("a.nextMonth");
    protected String dateDay="//td[@data-handler='selectDay']/a[contains(text(),$DAY)]";

    public HomePage() {
        super();
    }

    public void EnterOrigin(String origin){
        driver.findElement(fromTextBox).sendKeys(origin);
    }

    public void EnterDestination(String destination){
        driver.findElement(toTextBox).sendKeys(destination);
    }

    public void ChooseADepartOnDate(String day, String monthAndYear){
        driver.findElement(departOnDate).click();
        boolean flag=true;
        do{
            if(driver.findElement(dateMonthYear).getText().equals(monthAndYear)){
                driver.findElement(By.xpath(dateDay.replace("$DAY",day))).click();
                flag=false;
            }
            else
                driver.findElement(nextMonthLink).click();
        }
        while(flag);
    }
}
