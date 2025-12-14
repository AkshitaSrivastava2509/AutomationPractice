package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartPage {

    private  final WebDriver driver;

    public  CartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By productNameLocator = By.cssSelector("td.cart_description a");
    private final By cartRowLocator = By.cssSelector("table#cart_info_table tbody tr");
    private final By proceedToCheckoutLocator = By.cssSelector("a.check_out");
    private final By registerLoginLocator = By.xpath("//u[contains(text(),'Register / Login')]");
    private final By quantityLocator = By.cssSelector("td.cart_quantity button");
    private final By deleteLocator = By.cssSelector("a.cart_quantity_delete");
    private final By cartMessageLocator = By.id("empty_cart");

    public int cartItemSize(){
        return driver.findElements(cartRowLocator).size();

    }

    public void clickCheckoutButton(){
        driver.findElement(proceedToCheckoutLocator).click();
    }

    public  List<String> getProductName(){
        List<String> productsName = new ArrayList<String>();
        List<WebElement> rowsCount = driver.findElements(cartRowLocator);

        for (WebElement element:rowsCount){
            List<WebElement> e = element.findElements(productNameLocator);
            productsName.add(e.get(0).getText().trim());
        }
        return productsName;

    }

    public void clickRegisterLoginButton(){
        driver.findElement(registerLoginLocator).click();
    }

    public String getQuantity(){
        return driver.findElement(quantityLocator).getText();
    }

    public void removeProductsFromCart(){
        List<WebElement> productsRow = driver.findElements(cartRowLocator);
        Iterator<WebElement> iterator = productsRow.iterator();

        if (!productsRow.isEmpty()){
                while(iterator.hasNext()) {
                    productsRow.get(0).findElement(deleteLocator).click();
                }
                }else{
            System.out.println("cart is empty");
        }
    }

    public String getCartMessage(){
        return  driver.findElement(cartMessageLocator).getText();
    }

}
