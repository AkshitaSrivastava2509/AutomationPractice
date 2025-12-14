package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class ProductDetailPage {
    private final WebDriver driver;
    GenericUtils utils;

    public ProductDetailPage(WebDriver driver,GenericUtils utils){
        this.driver = driver;
        this.utils = utils;
    }


    private final By quantityLocator = By.id("quantity");
    private final By addToCartLocator = By.cssSelector("[type='button']");

    public  void updateQuantity(String quantity){
        driver.findElement(quantityLocator).clear();
        driver.findElement(quantityLocator).sendKeys(quantity);
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartLocator).click();
    }



}
