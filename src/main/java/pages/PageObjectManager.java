package pages;

import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class PageObjectManager {

    WebDriver driver;
    GenericUtils utils;

    public  PageObjectManager(WebDriver driver,GenericUtils utils){
        this.driver = driver;
        this.utils = utils;
    }

    public  SignUpPage getSignUpPage(){
        return new SignUpPage(driver);
    }

    public LandingPage getLandingPage() {
        return new LandingPage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public  ProductPage getProductPage(){
        return new ProductPage(driver,utils);
    }

    public  CartPage getCartPage(){
        return new CartPage(driver);
    }


}
