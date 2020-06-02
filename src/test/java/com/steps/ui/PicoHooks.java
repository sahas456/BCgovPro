package com.steps.ui;

import com.utilities.webDriver.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PicoHooks extends DriverFactory {

    Logger logger = LoggerFactory.getLogger(PicoHooks.class);

    @Before
    public void before(Scenario scenario) throws Exception {
        initializeDriver();
        logger.info("Scenario Started");
    }

    @After
    public void after()
    {
        logger.info("scenario ended");
        destroyDriver();
    }

}
