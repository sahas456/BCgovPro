package com.utilities.webDriver;

import java.io.File;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@Slf4j
public class SelectDriver {

    static  String browser;
    static WebDriver driver;
    static{
        browser = getBrowser();
    }

    public static String getBrowser()
    {
        return "firefox";
    }

    public static WebDriver getDriver() throws Exception {
        if (browser.toLowerCase().equals("chrome")) {
            return getChromeDriver();
        }
        else if(browser.toLowerCase().equals("firefox")){
            return getGeckoDriver();
        }
        else
        {
            throw new Exception("browser not defined");
        }
    }

    public static WebDriver getChromeDriver()
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.acceptInsecureCerts();
//        desiredCapabilities.
        File resourcesDirectory = new File("src/test/resources");
        String path = resourcesDirectory.getAbsolutePath() + "/drivers/chromedriver";
        //setting relative path
        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver(desiredCapabilities);
        return driver;
    }

    public static WebDriver getGeckoDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.acceptInsecureCerts();
        File resourcesDirectory = new File("src/test/resources");
        String path = resourcesDirectory.getAbsolutePath() + "/drivers/geckodriver";
        //setting relative path
        System.setProperty("webdriver.gecko.driver",path);
        driver = new FirefoxDriver(desiredCapabilities);

        return driver;
    }

}
