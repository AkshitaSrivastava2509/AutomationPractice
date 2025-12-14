package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.GenericUtils;

public class AccountRegistrationPage {

    private final WebDriver driver;
    GenericUtils utils;


    public AccountRegistrationPage(WebDriver driver, GenericUtils utils) {
        this.driver = driver;
        this.utils =utils;
    }

    private final By passwordLocator  = By.id("password");
    private final By firstNameLocator = By.id("first_name");
    private final By lastNameLocator  = By.id("last_name");
    private final By companyLocator   = By.id("company");
    private final By address1Locator  = By.id("address1");
    private final By address2Locator  = By.id("address2");
    private final By countryLocator   = By.id("country");
    private final By stateLocator     = By.id("state");
    private final By cityLocator      = By.id("city");
    private final By zipcodeLocator   = By.id("zipcode");
    private final By mobileLocator    = By.id("mobile_number");
    private final By createAccountLocator  = By.xpath("//button[contains(text(),'Create Account')]");
    private final By successMessageLocator = By.cssSelector("h2.title b");
    private final By continueLocator =By.xpath("//*[contains(text(),'Continue')]");


    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void enterCompany(String company){
        driver.findElement(companyLocator).sendKeys(company);
    }
    public void enterAddress1(String address1){
        driver.findElement(address1Locator).sendKeys(address1);
    }
    public void enterAddress2(String address2){
        driver.findElement(address2Locator).sendKeys(address2);
    }

    public void selectCountry(String country){
        Select select = new Select(driver.findElement(countryLocator));
        select.selectByValue(country);
    }

    public void enterState(String state){
        driver.findElement(stateLocator).sendKeys(state);
    }

    public void enterCity(String city){
        driver.findElement(cityLocator).sendKeys(city);
    }
    public void enterZipCode(String zipcode){
        driver.findElement(zipcodeLocator).sendKeys(zipcode);
    }
    public void enterMobile(String mobile){
        driver.findElement(mobileLocator).sendKeys(mobile);
    }

    public void clickCreateAccountButton(){
        utils.removeAds();
        utils.wait(createAccountLocator);
        driver.findElement(createAccountLocator).click();
    }


    public void fillRegistrationForm(String password,String fname,String lname, String company, String address, String address2, String country, String state, String city, String zipcode,String mobile){
        enterPassword(password);
        enterFirstName(fname);
        enterLastName(lname);
        enterCompany(company);
        enterAddress1(address);
        enterAddress2(address2);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipCode(zipcode);
        enterMobile(mobile);
        clickCreateAccountButton();
    }

    public  String getSuccessMessage(){
        return  driver.findElement(successMessageLocator).getText();
    }
    public  void clickContinueButton(){
         driver.findElement(continueLocator).click();
    }


}
