package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    private final By signupButton = By.xpath("//*[contains(text(),' Signup / Login')]");
    private final  By deleteAccountLocator = By.xpath("//*[contains(text(),'Delete Account')]");
    private final  By deleteMessageLocator  = By.cssSelector("h2[data-qa='account-deleted'] b");
    private final  By continueLocator = By.xpath("//*[contains(text(),'Continue')]");

    public String getLandingPageTitle(){
        return driver.getTitle();
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public  boolean isSignupLoginLinkDisplayed(){
        return  driver.findElement(signupButton).isDisplayed();
    }

    public void clickDeleteAccount(){
        driver.findElement(deleteAccountLocator).click();
    }

    public String getDeleteMessage(){
        return  driver.findElement(deleteMessageLocator).getText();
    }
    public void clickContinueButton(){
        driver.findElement(continueLocator).click();
    }


}
