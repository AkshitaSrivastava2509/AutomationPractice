package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private final WebDriver driver;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }
    private final By name = By.cssSelector("input[name='name']");
    private final By email = By.cssSelector("input[data-qa='signup-email']");
    private final By submitButton = By.cssSelector("button[data-qa='signup-button']");
    private final By errorMessage = By.cssSelector("form[action='/signup'] p");
    private final By accountInfoText = By.xpath("//*[contains(text(),'Enter Account Information')]");

    public String getUrl(){
       return driver.getCurrentUrl();
    }

    public void enterName(String username) {
        driver.findElement(name).sendKeys(username);
    }

    public void enterEmail(String emailAddress) {
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public String getAccountInfoText() {
        return driver.findElement(accountInfoText).getText();

    }
}
