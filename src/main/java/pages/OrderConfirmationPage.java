package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

        WebDriver driver;

        public OrderConfirmationPage(WebDriver driver){
            this.driver = driver;
        }

        private final By confirmationLocator = By.cssSelector("[data-qa='order-placed']");

        public String getConfirmationMessage(){
          return   driver.findElement(confirmationLocator).getText();
        }





}
