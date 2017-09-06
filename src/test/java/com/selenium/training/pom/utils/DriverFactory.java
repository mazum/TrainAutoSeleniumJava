package com.selenium.training.pom.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aby on 5/09/2017.
 */
public class DriverFactory {
    public static WebDriver driver;

    public static void StartDriver(String browser, String gridUrl) throws MalformedURLException {
        if (driver==null)
            CreateNewDriverInstance(browser, gridUrl);
    }

    private static void CreateNewDriverInstance(String browser, String gridUrl) throws MalformedURLException {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--use-gl=desktop");
                options.addArguments("disable-infobars");
                DesiredCapabilities capabilities=DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                capabilities.setPlatform(Platform.WIN10);
                capabilities.setJavascriptEnabled(true);
                if(gridUrl.isEmpty())
                    driver=new ChromeDriver(ChromeDriverService.createDefaultService(),options);
                else
                    driver=new RemoteWebDriver(new URL(gridUrl),capabilities);
                break;
            default:
                throw new NotImplementedException();
        }
    }

    public static void QuitDriver(){
        try {
            TakeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
        driver=null;
    }

    private static void TakeScreenShot() throws IOException {
        String filename="Screenshot_"+new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String artifactBaseDirectory="C:\\Users\\Aby\\Desktop\\Training\\Selenium\\screenshots\\";
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(artifactBaseDirectory + filename + ".png"));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
