package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LandingPage;
import pages.SignUpPage;
import utils.TextContextSetup;


public class SignUpSteps {

    TextContextSetup textContextSetup;
    SignUpPage signUpPage;
    LandingPage landingPage;

    public SignUpSteps(TextContextSetup textContextSetup) {
        this.textContextSetup = textContextSetup;
        this.signUpPage = textContextSetup.pageObjectManager.getSignUpPage();
        this.landingPage = textContextSetup.pageObjectManager.getLandingPage();
    }


    @Given("user is on Automation Exercise LandingPage")
    public void user_is_on_automation_exercise_landing_page() {
        System.out.println("User is on Landing Page");
    }

    @And("user click on Signup Login button")
    public void user_click_on_signup_login_button() {
        landingPage.clickSignupButton();
    }

    @When("user enter new name {string} and email {string}")
    public void user_enter_new_name_and_email(String name, String email) {
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
    }

    @When("click on Signup button")
    public void click_on_signup_button() {
        signUpPage.clickSubmitButton();
        System.out.println("clicking signup button");
    }

    @Then("user should be navigate to Signup page")
    public void user_should_be_navigate_to_signup_page() {
        String accountInfoMessage = signUpPage.getAccountInfoText();
        Assert.assertEquals(accountInfoMessage, "ENTER ACCOUNT INFORMATION");
    }


    @When("user enter name {string} and existing email {string}")
    public void user_enter_name_and_existing_email(String name, String email) {
            signUpPage.enterName(name);
            signUpPage.enterEmail(email);
        }

        @Then("user should see error message")
        public void userShouldSeeErrorMessage () {
            String actualErrorMessage = signUpPage.getErrorMessage();
            System.out.println(actualErrorMessage);
            Assert.assertEquals(actualErrorMessage, "Email Address already exist!");
        }
    }



