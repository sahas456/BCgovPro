package com.steps.ui;

import com.pages.permitPage.ApplyPermitPage;
import com.utilities.webDriver.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ApplyPermitPageSteps extends DriverFactory {
    private ApplyPermitPage applyPermitPage;

    public ApplyPermitPageSteps(){
        applyPermitPage = new ApplyPermitPage(driver);
    }


    @And("^I provide all the required details for all the stages$")
    public void iProvideAllTheRequiredDetailsForAllTheStages() {

    }

    @When("^I submit the application and navigate back to home page$")
    public void iSubmitTheApplication() {
        applyPermitPage.submitPermitApplicationBtn();
        applyPermitPage.agreeAndConfirm();
        //Assert.assertTrue("Permit submission failed ",applyPermitPage.permitSubmitted());
        applyPermitPage.backToHome();
    }

    @And("^I provide all the required details for all the permit stages$")
    public void iProvideAllTheRequiredDetailsForAllThePermitStages() {
        applyPermitPage.applicantInfoStage();
        applyPermitPage.infoStage();
//        applyPermitPage.parcelStage();
        applyPermitPage.workDescStage();
    }
}
