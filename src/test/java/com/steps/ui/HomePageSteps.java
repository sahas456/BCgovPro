package com.steps.ui;

import com.pages.homePage.HomePage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class HomePageSteps extends DriverFactory {

    private HomePage homepage;
    public HomePageSteps()
    {
        homepage = new HomePage(driver);
    }


    @And("^I validate user is on the home page$")
    public void iValidateUserIsOnTheHomePage() {
        Assert.assertTrue("User is not on home page",homepage.verifyUserOnHomepage());
    }

    @And("^I navigate to apply permit page by selecting the permit type (.*)$")
    public void iNavigateToApplyingPermitPageBySelectingTheType(String permitType) {
        homepage.navigateToApplyPermitSection(permitType.trim());
        Assert.assertTrue("User is not on Permit Page",homepage.userOnApplyPermitPage());
    }

    @Then("^I Validate the Parcel is created and displayed in the permits list on home page$")
    public void iValidateTheParcelIsCreatedAndDisplayedInThePermitsListOnHomePage() {
        Assert.assertTrue("new Permit not created ",homepage.newPermitCreated());
    }

    @And("^I Validate the address on the parcel view page is correct$")
    public void iValidateTheAddressOnTheParcelViewPageIsCorrect() {
        Assert.assertTrue("Address is not correct on the parcel ",homepage.correctAddressIsDisplayed());
    }


}
