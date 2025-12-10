package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    private final By signupButton = By.xpath("//*[contains(text(),' Signup / Login')]");

    public String getLandingPageTitle(){
        return driver.getTitle();
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }



}
