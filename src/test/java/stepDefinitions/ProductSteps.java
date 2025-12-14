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
import pages.ProductDetailPage;
import pages.ProductPage;
import utils.TextContextSetup;

import java.util.List;
import java.util.Map;

public class ProductSteps {

    private final LoginPage loginPage;
    private final ProductPage productPage;
    private final CartPage cartPage;
    ProductDetailPage productDetailPage;
    TextContextSetup textContextSetup;

    public ProductSteps(TextContextSetup textContextSetup){
        this.textContextSetup = textContextSetup;
        this.loginPage        = textContextSetup.pageObjectManager.getLoginPage();
        this.productPage      = textContextSetup.pageObjectManager.getProductPage();
        this.cartPage         = textContextSetup.pageObjectManager.getCartPage();
        this.productDetailPage= textContextSetup.pageObjectManager.getProductDetailPage();
    }


    @Given("user logged in with valid email {string} and password {string}")
    public void userLoggedInWithValidEmailAndPassword(String email, String password) {
        loginPage.setLogin(email, password);
    }

    @Given("user navigate to Product page")
    public void user_navigate_to_product_page() {
        productPage.clickProductLink();
    }

    @When("user added first product {string} to the carts")
    public void userAddedFirstProductToTheCarts(String product) {

        productPage.addProductToCart(product);
    }

    @And("click on Continue Shopping button")
    public void clickOnContinueShoppingButton() {
        productPage.clickContinueShopping();
    }

    @And("add one more product {string} to the cart")
    public void addOneMoreProductToTheCart(String product) {
        productPage.addProductToCart(product);
    }

    @And("click on View Cart button")
    public void clickOnViewCartButton() {
        productPage.clickViewCart();
    }

    @Then("user should see both the  products in the cart")
    public void userShouldSeeBothTheProductsInTheCart() {
        System.out.println("Cart size: " + cartPage.cartItemSize());
        Assert.assertEquals(cartPage.cartItemSize(), 2);
    }

    @And("cart should persist after refresh")
    public void cartShouldPersistAfterRefresh() {
        List<String> nameBeforeRefresh = cartPage.getProductName();
        DriverFactory.getDriver().navigate().refresh();
        List<String> nameAfterRefresh = cartPage.getProductName();
        Assert.assertEquals(nameAfterRefresh, nameBeforeRefresh);
    }


    @When("user search for product {string}")
    public void userSearchForProduct(String productName) {
        productPage.searchProduct(productName);
    }

    @Then("search results should contain word {string}")
    public void searchResultsShouldContainWord(String productName) {

        List<String> productNamesList = productPage.getAllProductName();
        productNamesList.forEach(productsName->Assert.assertTrue(productsName.toLowerCase().contains(productName.toLowerCase()),
                "Invalid product found "+ productName));
    }


    @When("user add product first product to the cart with quantity {string}")
    public void userAddProductFirstProductToTheCartWithQuantity(String quantity) {
        productPage.clickViewProduct();
        productDetailPage.updateQuantity(quantity);
        productDetailPage.clickAddToCartButton();
    }

    @And("user navigate to cart")
    public void userNavigateToCart() {
        productPage.clickViewCart();
    }

    @Then("user should see quantity {string} for the added product")
    public void userShouldSeeQuantityForTheAddedProduct(String quantity) {

        String quantityOnCartPage = cartPage.getQuantity();
        Assert.assertEquals(quantityOnCartPage, quantity);

    }

    @And("user navigate to cartPage")
    public void userNavigateToCartPage() {
        productPage.clickCartMenuLink();
    }

    @When("user click on delete all the products from the cart")
    public void userClickOnDeleteAllTheProductsFromTheCart() {
        cartPage.removeProductsFromCart();
    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String message) {

        String cartMessage = cartPage.getCartMessage();
        Assert.assertEquals(cartMessage, message);
    }

}

