package com.steps.ui;

import com.pages.loginPage.LoginPage;
import com.utilities.reader.TestDataReader;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginPageSteps extends DriverFactory {

    private LoginPage loginPage;
    private TestDataReader testDataReader;
    public LoginPageSteps()
    {
    loginPage = new LoginPage(driver);
    testDataReader = new TestDataReader();
    }

    @Given("^I navigate to the swaglabs login page$")
    public void iNavigateToTheFirmexHomePage() {
        driver.get("https://www.saucedemo.com/index.html");

    }

    @Given("^I navigate to the Bussiness account login page$")
    public void iNavigateToTheBussinessAccountLoginPage() {
        loginPage.navigateToLoginPage();
        Assert.assertTrue("User is not on Login page",loginPage.verifyUserOnLoginPage());
    }

    @When("^I login to the application as a valid user$")
    public void iLoginToTheApplicationAsAStandardUser() {
        loginPage.login();
    }
}
