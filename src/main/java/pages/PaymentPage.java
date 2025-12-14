package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class PaymentPage {

    WebDriver driver;
    GenericUtils utils;

    public PaymentPage(WebDriver driver, GenericUtils utils){
        this.driver = driver;
        this.utils = utils;
    }

    private final By nameLocator = By.name("name_on_card");
    private final By cardNumberLocator = By.name("card_number");
    private final By cvvLocator = By.name("cvc");
    private final By monthLocator = By.name("expiry_month");
    private final By yearLocator = By.name("expiry_year");
    private final By submitLocator = By.id("submit");

    public void enterName(String nameOnCard){
        driver.findElement(nameLocator).sendKeys(nameOnCard);
    }
    public void enterCardNumber(String cardNumber){
        driver.findElement(cardNumberLocator).sendKeys(cardNumber);
    }
    public void enterCVV(String cvv){
        driver.findElement(cvvLocator).sendKeys(cvv);
    }
    public void enterMonth(String month){
        driver.findElement(monthLocator).sendKeys(month);
    }

    public void enterYear(String year){
        driver.findElement(yearLocator).sendKeys(year);
    }
    public void clickSubmit(){
        utils.wait(submitLocator);
        driver.findElement(submitLocator).click();
    }

    public void enterPaymentDetail(String name, String card, String cvv, String month, String year){
        utils.removeAds();
        enterName(name);
        enterCardNumber(card);
        enterCVV(cvv);
        enterMonth(month);
        enterYear(year);
    }
}
