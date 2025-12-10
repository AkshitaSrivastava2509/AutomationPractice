package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import utils.TextContextSetup;

public class LoginSteps {

    TextContextSetup textContextSetup;

    public LoginSteps(TextContextSetup textContextSetup){
        this.textContextSetup = textContextSetup;
    }

    @Given("user enter valid  email {string} and password {string}")
    public void userEnterValidEmailAndPassword(String email, String password) {
        textContextSetup.pageObjectManager.getLoginPage().enterEmail(email);
        textContextSetup.pageObjectManager.getLoginPage().enterPassword( password);
    }

    @When("user click on Login button")
    public void user_click_on_login_button() {
        textContextSetup.pageObjectManager.getLoginPage().clickLogin();
        }

    @Then("user should be logged in successfully and see Logged in as username")
    public void user_should_be_logged_in_successfully_and_see_logged_in_as_username() {
        String loggedText = textContextSetup.pageObjectManager.getLoginPage().getLoggedInText();
        Assert.assertEquals(loggedText, "Logged in as cucumbertest");
    }


    @Given("user enter invalid {} and {}")
    public void userEnterInvalidAnd(String email, String password) {
        textContextSetup.pageObjectManager.getLoginPage().enterEmail(email);
        textContextSetup.pageObjectManager.getLoginPage().enterPassword(password);
    }

    @Then("user should see error message {}")
    public void userShouldSeeErrorMessage(String errorMessage) {
        String error_message = textContextSetup.pageObjectManager.getLoginPage().getErrorMessage();
        Assert.assertEquals(error_message, errorMessage);

    }


}
