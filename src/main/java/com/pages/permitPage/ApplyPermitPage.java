package com.pages.permitPage;

import com.pages.basePage.BasePage;
import com.utilities.WaitUtils;
import com.utilities.reader.TestDataReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ApplyPermitPage extends BasePage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private TestDataReader testDataReader;

    public ApplyPermitPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        testDataReader = new TestDataReader();
    }

    @FindBy(xpath = "//button[contains(text(),'Apply For Permit')]")
    WebElement permitButton;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement nextButton;

    @FindBy(xpath = "//input[@name = 'FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name = 'LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name = 'Email']")
    WebElement email;

    @FindBy(xpath = "//textarea[@name = 'MailingStreet']")
    WebElement MailingStreetinput;

    @FindBy(xpath = "//input[@name = 'MailingCity']")
    WebElement MailingCityinput;

    @FindBy(xpath = "//input[@name = 'MailingState']")
    WebElement MailingStateinput;

    @FindBy(xpath = "//input[@name = 'MailingPostalCode']")
    WebElement MailingPostalinput;

    @FindBy(xpath = "//input[@name = 'MailingCountry']")
    WebElement MailingCountryinput;

    @FindBy(xpath = "//input[@name = 'Phone'][1]")
    WebElement BussinessPhoneinput;

    @FindBy(xpath = "//input[@name = 'MobilePhone']")
    WebElement MobilePhoneinput;

    @FindBy(xpath = "//input[@name = 'Name']")
    WebElement AccountNameinput;

    @FindBy(xpath = "//input[@name = 'Phone'][2]")
    WebElement AccountPhoneinput;

    public void applicantInfoStage(){
        waitUtils.getElementAfterLongWait(firstName).isDisplayed();
//        firstName.sendKeys(testDataReader.readData("Firstname"));
//        lastName.sendKeys(testDataReader.readData("Lastname"));
//        email.sendKeys(testDataReader.readData("email"));
       // MailingStreetinput.sendKeys(testDataReader.readData("MailingStreetinput"));
//        MailingCityinput.sendKeys(testDataReader.readData("MailingCityinput"));
//        MailingStateinput.sendKeys(testDataReader.readData("MailingStateinput"));
//        MailingPostalinput.sendKeys(testDataReader.readData("MailingPostalcodeinput"));
//        MailingCountryinput.sendKeys(testDataReader.readData("MailingCountryinput"));
//        BussinessPhoneinput.sendKeys(testDataReader.readData("MailingBussinessPhoneinput"));
//        MobilePhoneinput.sendKeys(testDataReader.readData("MailingAccountPhoneinput"));
//        AccountNameinput.sendKeys(testDataReader.readData("AccountNameinput"));
//        AccountPhoneinput.sendKeys(testDataReader.readData("AccountPhoneinput"));
        nextButton.click();
    }

    @FindBy(xpath = "//label[contains(text(),'Use Class')]")
    WebElement infoLabel;

    @FindBy(how = How.XPATH, using = "//li[1]//span[1]//div[1]//span[1]")
    public static WebElement address_selection;

    public void infoStage(){
        waitUtils.getElementAfterMediumWait(infoLabel).isDisplayed();
        nextButton.click();
    }

    public void parcelStage() throws InterruptedException {
        waitUtils.getElementAfterMediumWait(inputlocation).isDisplayed();
        String inputLoc = testDataReader.readData("inputlocation");
        inputlocation.sendKeys(inputLoc);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        address_selection.click();
        Thread.sleep(2000);
        selectButton.click();
        nextButton.click();

    }
    @FindBy(xpath = "//input[@name = 'location']")
    WebElement inputlocation;

    @FindBy(xpath = "//button[contains(text(),'Select')]")
    WebElement selectButton;

    public void workDescStage(){
        waitUtils.getElementAfterMediumWait(inputBuildingNumber).isDisplayed();
        inputBuildingNumber.sendKeys(testDataReader.readData("inputBuildingNumber"));
        inputUnitNumber.sendKeys(testDataReader.readData("inputUnitNumber"));
        nextButton.click();
    }

    public void submitPermitApplicationBtn(){
        waitUtils.getElementAfterMediumWait(submitPermitApplicationButton).isDisplayed();
        JavascriptExecutor js = (JavascriptExecutor)(driver);
        js.executeScript("arguments[0].click()",submitPermitApplicationButton);
//        submitPermitApplicationButton.click();
    }

    @FindBy(xpath = "//input[@name = 'Building_Number__c' ]")
    WebElement inputBuildingNumber;

    @FindBy(xpath = "//input[@name = 'Unit_Number__c' ]")
    WebElement inputUnitNumber;

    @FindBy(xpath = "//button[contains(text(),'Submit Permit Application')]")
    WebElement submitPermitApplicationButton;

    public void agreeAndConfirm(){
        waitUtils.getElementAfterMediumWait(checkboxButton).isDisplayed();
        checkboxButton.click();
        AgreeButton.click();
    }

    public boolean permitSubmitted(){
        waitUtils.getElementAfterLongWait(permitSubmitAlert).isDisplayed();
        String test = permitSubmitAlert.getText();
        return permitSubmitAlert.getText().contains("Your Permit Application has been submitted and is now being "
            + "processed. Your reference number is ");
    }

    public void backToHome(){
        waitUtils.getElementAfterMediumWait(backtohomeButton).isDisplayed();
        JavascriptExecutor js = (JavascriptExecutor)(driver);
        js.executeScript("arguments[0].click()",backtohomeButton);
        waitUtils.getElementAfterMediumWait(permitButton).isDisplayed();
    }

    @FindBy(xpath = "//input[@role = 'alert']")
    WebElement permitSubmitAlert;

     @FindBy(xpath = "//input[@name = 'agree-checkbox']")
     WebElement checkboxButton;

     @FindBy(xpath = "//button[contains(text(),'I Agree')]")
     WebElement AgreeButton;

     @FindBy(xpath = "//button[contains(text(),'Back To Home')]")
     WebElement backtohomeButton;

}
