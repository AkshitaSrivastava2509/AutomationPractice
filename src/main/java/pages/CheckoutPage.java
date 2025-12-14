package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;
import utils.TextContextSetup;

public class CheckoutPage {

    WebDriver driver;
    GenericUtils utils;

    public CheckoutPage(WebDriver driver, GenericUtils utils){
        this.driver = driver;
        this.utils = utils;
    }

    private final By placeOrderLocator = By.xpath("//a[contains(text(),'Place Order')]");

    public void clickPlaceOrderButton(){
        utils.removeAds();
        utils.wait(placeOrderLocator);
        driver.findElement(placeOrderLocator).click();
    }
}
