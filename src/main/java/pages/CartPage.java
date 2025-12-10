package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private  final WebDriver driver;

    public  CartPage(WebDriver driver){
        this.driver = driver;
    }

    private  final By productNameLocator = By.cssSelector("td.cart_description a");
    private final By cartRowLocator = By.cssSelector("table#cart_info_table tbody tr");

    public int cartItemSize(){
        return driver.findElements(cartRowLocator).size();

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

}
