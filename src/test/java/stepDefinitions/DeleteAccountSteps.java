package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LandingPage;
import pages.ProductPage;
import utils.TextContextSetup;

public class DeleteAccountSteps {

    TextContextSetup textContextSetup;
    LandingPage landingPage;

    public  DeleteAccountSteps(TextContextSetup textContextSetup){
       this.textContextSetup = textContextSetup;
       this.landingPage = textContextSetup.pageObjectManager.getLandingPage();
    }

    @When("user click on delete account link")
    public void user_click_on_delete_account_link() {

        landingPage.clickDeleteAccount();
        System.out.println("Delete Account link is clicked");
    }
    @Then("account delete message text should be {string}")
    public void account_delete_message_text_should_be(String deleteMessage) {
        String message = landingPage.getDeleteMessage();
        Assert.assertEquals(message, deleteMessage);
    }
    @Then("on clicking continue user redirect to Landing Page")
    public void on_clicking_continue_user_redirect_to_landing_page() {
        landingPage.clickContinueButton();
        Assert.assertTrue(landingPage.isSignupLoginLinkDisplayed());
    }

  }
