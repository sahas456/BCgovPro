package com.pages.loginPage;

import com.pages.basePage.BasePage;
import com.utilities.reader.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private WebDriver driver;
    private TestDataReader testDataReader;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        testDataReader = new TestDataReader();

    }


    @FindBy(xpath = "//input[@placeholder = 'Email']")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder = 'Password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'View')]")
    WebElement ViewButton;

    public void navigateToLoginPage() {
        String URL = testDataReader.readData("URL");
        driver.get(URL);
    }


    public void login(){
        email.sendKeys(testDataReader.readData("email"));
        password.sendKeys(testDataReader.readData("password"));
        loginButton.click();
    }

    public boolean verifyUserOnLoginPage(){
        return driver.getCurrentUrl().contains("https://sandbox-customization-data");
    }
}
