package com.utilities.webDriver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class DriverFactory {


    protected static WebDriver driver;

    public DriverFactory()
    {
    }

    public void initializeDriver() throws Exception {
        if(driver == null)
        {
            driver  =  SelectDriver.getDriver();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
           // driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void destroyDriver()
    {
        if(driver != null)
        {
            driver.close();
//            driver.quit();
            driver = null;
        }
    }

}
