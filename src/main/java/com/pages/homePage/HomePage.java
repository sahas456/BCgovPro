package com.pages.homePage;

import java.util.List;

import com.pages.basePage.BasePage;
import com.utilities.HelperUtils;
import com.utilities.WaitUtils;
import com.utilities.reader.TestDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//LoadableComponent<HomePage>
public class HomePage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'Personal Information')]")
    WebElement personalInfoHeader;

    @FindBy(xpath = "//button[contains(text(),'Apply For Permit')]")
    WebElement applyPermitBtn;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement nextBtn;

    @FindBy(xpath = "//h2[contains(text(),'Parcel')]")
    WebElement parcellink;

    @FindBy(xpath = "//article[@data-aura-class='bgccBaseComponent']/div/ul/li[1]")
    WebElement firstPermit;

    private WaitUtils waitUtils;
    private WebDriver driver;
    private TestDataReader testDataReader;
    private HelperUtils helperUtils;

   public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        testDataReader = new TestDataReader();
        helperUtils = new HelperUtils();
    }

   public boolean newPermitCreated(){
       int newCnt = getPermitsCount();
       int oldcnt = helperUtils.getPermitsCnt();
       return newCnt == (oldcnt+1);


   }

   public boolean correctAddressIsDisplayed(){
       String  in = firstPermit.getText();
       return in.contains(testDataReader.readData("expectedLocation"));
   }

    public Boolean verifyUserOnHomepage(){
        return waitUtils.getElementAfterLongWait(applyPermitBtn).isDisplayed();
    }

    public void navigateToApplyPermitSection(String permitType){
       waitUtils.getElementAfterShortWait(applyPermitBtn).isDisplayed();
       int cnt = getPermitsCount();
       helperUtils.setPermitsCount(cnt);
       applyPermitBtn.click();
       waitUtils.getElementAfterLongWait(driver.findElement(By.xpath("//span[contains(text(),'Electrical')]"))).click();
       nextBtn.click();

    }

    public boolean userOnApplyPermitPage(){

       return waitUtils.getElementAfterLongWait(parcellink).isDisplayed();
    }

    private int getPermitsCount(){
       List<WebElement> listOfPermits = driver.findElements(By.xpath("//article[@data-aura-class='bgccBaseComponent"
           + "']/div/ul/li"));
       return listOfPermits.size();
    }

}
