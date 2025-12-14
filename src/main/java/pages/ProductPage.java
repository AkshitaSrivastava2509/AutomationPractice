package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    private final WebDriver driver;
    GenericUtils utils;

    public ProductPage(WebDriver driver,GenericUtils utils){
        this.driver = driver;
        this.utils = utils;
    }

    private final By productNameLocator      = By.tagName("p");
    private final By productLinkLocator      = By.xpath("//a[@href='/products']");
    private final By continueShoppingLocator = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private final By viewCartLocator         = By.cssSelector("p.text-center a");
    private final By productCardLocator      = By.cssSelector(".productinfo.text-center");
    private final By addToCartRelative       = By.xpath(".//a[contains(text(),'Add to cart')]");
    private final By cartMenuLocator         = By.linkText("Cart");
    private final By dressLocator            = By.id("search_product");
    private final By searchButtonLocator     = By.id("submit_search");
    private final By viewProductLocator         = By.xpath("//a[contains(text(),'View Product')]");


    public void clickProductLink(){
        driver.findElement(productLinkLocator).click();
    }

    public  void clickContinueShopping(){
        utils.wait(continueShoppingLocator);
        driver.findElement(continueShoppingLocator).click();

    }

    public  void clickViewCart(){

        utils.wait(viewCartLocator);
        driver.findElement(viewCartLocator).click();
    }

    public void addProductToCart(String productName) {
        utils.removeAds();
        for (int i = 0; i < 6; i++) {
            // Scroll chunk by chunk
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600)");
            utils.removeAds();
            List<WebElement> products = driver.findElements(productCardLocator);

            for (WebElement element : products) {
                String name = element.findElement(productNameLocator).getText().trim();

                if (name.equalsIgnoreCase(productName)) {
                    ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].scrollIntoView({block:'center'});", element);
                    utils.removeAds();
                    WebElement addToCart = element.findElement(addToCartRelative);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
                    System.out.println(productName + " added to cart.");
                    return;
                }
            }
        }

        throw new RuntimeException("Product '" + productName + "' not found after scrolling.");
    }

    public void clickCartMenuLink(){
        driver.findElement(cartMenuLocator).click();
    }

    public void searchProduct(String productName){
        utils.removeAds();
        driver.findElement(dressLocator).sendKeys(productName);
        driver.findElement(searchButtonLocator).click();
    }

    public List<String> getAllProductName(){
        utils.removeAds();
        List<WebElement> products = driver.findElements(productCardLocator);
        List<String> productNames = new ArrayList<String>();
        for (WebElement element :products){
            productNames.add(element.getText());
        }
        return productNames;
    }

    public void clickViewProduct(){
        driver.findElement(viewProductLocator).click();
    }
}
