package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LandingPage;
import pages.SignUpPage;
import utils.TextContextSetup;


public class SignUpSteps {

    TextContextSetup textContextSetup;

    public SignUpSteps(TextContextSetup textContextSetup){
        this.textContextSetup = textContextSetup;
    }


    @Given("User is on Automation Exercise LandingPage")
    public void userIsOnAutomationExerciseLandingPage() {
        System.out.println("User is on Landing Page");

    }

    @Given("user click on Signup Login button")
    public void user_click_on_signup_login_button() {

       textContextSetup.pageObjectManager.getLandingPage().clickSignupButton();
    }

    @When("user enter new {string} and {string}")
    public void user_enter_new_and(String name, String email) {

        textContextSetup.pageObjectManager.getSignUpPage().enterName(name);
        textContextSetup.pageObjectManager.getSignUpPage().enterEmail(email);

    }

    @When("user click on Signup button")
    public void user_click_on_signup_button() {
        textContextSetup.pageObjectManager.getSignUpPage().clickSubmitButton();
        System.out.println("clicking signup button");
    }

    @Then("user should be navigate to Signup page")
    public void user_should_be_navigate_to_signup_page() {
       String accountInfoMessage = textContextSetup.pageObjectManager.getSignUpPage().getAccountInfoText() ;
        Assert.assertEquals(accountInfoMessage, "ENTER ACCOUNT INFORMATION");
    }


    @When("user enter name  {string} and existing email {string}")
    public void userEnterNameAndExistingEmail(String name, String email) {
        textContextSetup.pageObjectManager.getSignUpPage().enterName(name);
        textContextSetup.pageObjectManager.getSignUpPage().enterEmail(email);
    }

    @Then("user should see error message")
    public void userShouldSeeErrorMessage() {
        String actualErrorMessage = textContextSetup.pageObjectManager.getSignUpPage().getErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, "Email Address already exist!");
    }
}


