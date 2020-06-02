package com.pages.loginPage;

import com.pages.basePage.BasePage;
import com.utilities.reader.TestDataReader;
import org.openqa.selenium.NoSuchElementException;
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


    // view page add view page

   // @FindBy(xpath = /html/body/div[3]/div[2]/div/div[2]/div/div/article/div/div/div[3]/div/div/div/div/div[1
   // ]/lightning-output-field/div/lightning-formatted-text)
   // WebElement ParcelName;

    // @FindBy(xpath = /html/body/div[3]/div[2]/div/div[2]/div/div/article/div/div/div[3]/div/div/div/div/div[3
    // ]/lightning-output-field/div/lightning-formatted-text)
   // WebElement ParcelName;

    public void login(String val)
    {
        String uname = "";
        String pass = "";

        switch(val){
        case ("standard"):
            uname = "standard_user";
            pass = "secret_sauce";
            break;
        case ("problem"):
                uname = "problem_user";
                pass = "secret_sauce";
                break;
            case ("locked_out"):
                uname = "locked_out_user";
                pass = "secret_sauce";
                break;
            case ("performance_glitch_user"):
                uname = "performance_glitch_user";
                pass = "secret_sauce";
                break;
        case ("invalid"):
            uname = "test@gmail.com";
            pass = "test@123";
            break;

        default:
            System.out.println("not a valid input ");
                   }
        try {
//            username.clear();
//            username.sendKeys(uname);
//            password.clear();
//            password.sendKeys(pass);
//            login.click();
        }catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void navigateToLoginPage() {
        String URL = testDataReader.readData("URL");
        driver.get(URL);
    }


    public void login(){
        email.sendKeys(testDataReader.readData("email"));
        password.sendKeys(testDataReader.readData("password"));
        loginButton.click();
       // waitUtils.waitForElementToDisappear(loginButton);
    }

    public boolean verifyUserOnLoginPage(){
        return driver.getCurrentUrl().contains("https://sandbox-customization-data");
    }
}
