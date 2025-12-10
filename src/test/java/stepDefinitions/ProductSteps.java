package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.TextContextSetup;

import java.util.List;
import java.util.Map;

public class ProductSteps {

    private ProductPage productPage;
    private  CartPage cartPage;
    TextContextSetup textContextSetup;


    public ProductSteps(TextContextSetup textContextSetup){
        this.textContextSetup = textContextSetup;
    }


    @Given("user should be logged in with valid credential")
    public void user_should_be_logged_in_with_valid_credential(DataTable dataTable) {

        List<Map<String, String>> credList = dataTable.asMaps();
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        textContextSetup.pageObjectManager.getLoginPage().setLogin(username, password);

    }

    @Given("user should be navigate to product page")
    public void user_should_be_navigate_to_product_page() {
        textContextSetup.pageObjectManager.getProductPage().clickProductLink();
    }

    @When("user added first product {string} to the carts")
    public void userAddedFirstProductToTheCarts(String product) {

        textContextSetup.pageObjectManager.getProductPage().addProductToCart(product);
    }

    @And("click on Continue Shopping button")
    public void clickOnContinueShoppingButton() {
        textContextSetup.pageObjectManager.getProductPage().clickContinueShopping();
    }

    @And("add one more product {string} to the cart")
    public void addOneMoreProductToTheCart(String product) {
        textContextSetup.pageObjectManager.getProductPage().addProductToCart(product);
    }

    @And("click on View Cart button")
    public void clickOnViewCartButton() {
       textContextSetup.pageObjectManager.getProductPage().clickViewCart();
    }

    @Then("user should see both the  products in the cart")
    public void userShouldSeeBothTheProductsInTheCart() {
        System.out.println("Cart size: " + textContextSetup.pageObjectManager.getCartPage().cartItemSize());
        Assert.assertEquals(textContextSetup.pageObjectManager.getCartPage().cartItemSize(), 2);
    }

    @And("cart should persist after refresh")
    public void cartShouldPersistAfterRefresh() {

        List<String> nameBeforeRefresh = textContextSetup.pageObjectManager.getCartPage().getProductName();

        DriverFactory.getDriver().navigate().refresh();
        List<String> nameAfterRefresh = textContextSetup.pageObjectManager.getCartPage().getProductName();

        Assert.assertEquals(nameAfterRefresh, nameBeforeRefresh);

    }



}

