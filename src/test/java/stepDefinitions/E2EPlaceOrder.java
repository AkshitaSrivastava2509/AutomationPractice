package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.TextContextSetup;


import java.util.List;
import java.util.Map;

public class E2EPlaceOrder {

    private final ProductPage productPage;
    private final CartPage cartPage;
    private final SignUpPage signupPage;
    private final CheckoutPage checkoutPage;
    private final PaymentPage paymentPage;
    private final OrderConfirmationPage orderConfirmationPage;
    private final AccountRegistrationPage accountRegistrationPage;
    TextContextSetup textContextSetup;

    public E2EPlaceOrder(TextContextSetup textContextSetup){
        this.textContextSetup =textContextSetup;
        this.productPage = textContextSetup.pageObjectManager.getProductPage();
        this.cartPage = textContextSetup.pageObjectManager.getCartPage();
        this.signupPage = textContextSetup.pageObjectManager.getSignUpPage();
        this.accountRegistrationPage = textContextSetup.pageObjectManager.getAccountRegistrationPage();
        this.checkoutPage = textContextSetup.pageObjectManager.getCheckoutPage();
        this.paymentPage = textContextSetup.pageObjectManager.getPaymentPage();
        this.orderConfirmationPage = textContextSetup.pageObjectManager.getOderConfirmationPage();
    }

    @Given("user added product {string} and {string} to the cart")
    public void userAddedProductAndToTheCart(String productOne, String productTwo) {
        productPage.clickProductLink();
        productPage.addProductToCart(productOne);
        productPage.clickContinueShopping();
        productPage.addProductToCart(productTwo);

    }

    @When("user open the cart and clicks proceed to checkout")
    public void userOpenTheCartAndClicksProceedToCheckout() {
        productPage.clickViewCart();

        cartPage.clickCheckoutButton();
    }

    @And("user choose to register or login with credential {string} and {string}")
    public void userChooseToRegisterOrLoginWithCredentialAnd(String name, String email) {
        cartPage.clickRegisterLoginButton();
        signupPage.enterName(name);
        signupPage.enterEmail(email);
        signupPage.clickSubmitButton();
    }

    @And("user completes account registration with the following details")
    public void userCompletesAccountRegistrationWithTheFollowingDetails(DataTable dataTable) {

        List<Map<String, String>> list = dataTable.asMaps();
        String password   = list.get(0).get("password");
        String first_name = list.get(0).get("firstName");
        String last_name  = list.get(0).get("lastName");
        String company    = list.get(0).get("company");
        String address1   = list.get(0).get("address1");
        String address2   = list.get(0).get("address2");
        String country    = list.get(0).get("country");
        String state      = list.get(0).get("state");
        String city       = list.get(0).get("city");
        String zipcode    = list.get(0).get("zipcode");
        String mobileNumber  = list.get(0).get("mobileNumber");

        accountRegistrationPage.fillRegistrationForm(password, first_name,last_name,company,address1,address2,country,state,city,zipcode,mobileNumber);
    }

    @Then("user should see Account Created confirmation")
    public void userShouldSeeAccountCreatedConfirmation() {
        String message = accountRegistrationPage.getSuccessMessage();
        Assert.assertEquals(message,"ACCOUNT CREATED!");
        System.out.println("Account is successfully create");
    }

    @When("user clicks Continue after registration")
    public void userClicksContinueAfterRegistration() {
        accountRegistrationPage.clickContinueButton();

    }

    @And("user goes to cart and proceeds to checkout")
    public void userGoesToCartAndProceedsToCheckout() {
        productPage.clickCartMenuLink();
        cartPage.clickCheckoutButton();
    }

    @And("user enters delivery address")
    public void userEntersDeliveryAddress() {
        System.out.println( "User entered address");
        checkoutPage.clickPlaceOrderButton();
    }

    @And("user enters payment details")
    public void userEntersPaymentDetails(DataTable datatable) {
        List<Map<String,String>> paymentList = datatable.asMaps();
        String cardName = paymentList.get(0).get("cardName");
        String cardNumber = paymentList.get(0).get("cardNumber");
        String cvc = paymentList.get(0).get("cvc");
        String expiryMonth = paymentList.get(0).get("expiryMonth");
        String expiryYear = paymentList.get(0).get("expiryYear");

        paymentPage.enterPaymentDetail(cardName, cardNumber,cvc, expiryMonth, expiryYear);
    }

    @And("user places the order")
    public void userPlacesTheOrder() {
        paymentPage.clickSubmit();
        System.out.println("Order is successfully placed");
    }

    @Then("user should see order success message {string}")
    public void userShouldSeeOrderSuccessMessage(String confirm) {

        String message = orderConfirmationPage.getConfirmationMessage();
        Assert.assertEquals(message, confirm);
    }


    @Then("The saved address details should be loaded correctly")
    public void theSavedAddressDetailsShouldBeLoadedCorrectly() {
        checkoutPage.clickPlaceOrderButton();
        System.out.println("Address is added correctly");

    }
}
