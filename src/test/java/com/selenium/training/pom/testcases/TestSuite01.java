package com.selenium.training.pom.testcases;

import com.selenium.training.pom.pages.HomePage;
import com.selenium.training.pom.pages.HotelPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Aby on 5/09/2017.
 */
public class TestSuite01 {
    HomePage homePage;
    HotelPage hotelPage;

    @BeforeMethod
    public void beforeTest(){
        homePage=new HomePage();
    }

    @Test
    public void Test01() throws InterruptedException {
        homePage.EnterOrigin("New Delhi");
        homePage.EnterDestination("Auckland");
        homePage.ChooseADepartOnDate("21","October 2017");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterTest(){
        homePage.QuitBrowser();
    }
}
