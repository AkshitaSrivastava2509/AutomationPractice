package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

   private final WebDriver driver;


   public LoginPage(WebDriver driver){
       this.driver = driver;
   }

   private final By emailLocator = By.cssSelector("input[data-qa='login-email']");
   private final By passwordLocator = By.cssSelector("input[name='password']");
   private final By loginButtonLocator = By.xpath("//button[contains(text(),'Login')]");
   private final By loggedInText = By.xpath("//a[contains(text(),' Logged in as ')]");
   private final  By errorMessageLocator = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

   public  void enterEmail(String email){
       driver.findElement(emailLocator).sendKeys(email);
   }

   public void enterPassword(String password){
       driver.findElement(passwordLocator).sendKeys(password);
   }

   public void clickLogin(){
      driver.findElement(loginButtonLocator).click();
   }

   public void setLogin(String email, String password){
       enterEmail(email);
       enterPassword(password);
       clickLogin();
   }

    public String getLoggedInText() {
        return driver.findElement(loggedInText).getText();

    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageLocator).getText();
    }
}
