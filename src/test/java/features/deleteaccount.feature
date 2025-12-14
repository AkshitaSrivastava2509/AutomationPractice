Feature: Delete Account and verify Redirection

  As a register user,
  I want to delete my account.
  So that my account is permanently delete and I am logged out

  Background:
    Given user is on Automation Exercise LandingPage
    And user click on Signup Login button

  @deleteAccount
    Scenario: Delete Account and verify successful redirection
      Given  user enter valid  email "testusernewreg22@example.com" and password "1234"
      And user click on Login button
      When user click on delete account link
      Then account delete message text should be "ACCOUNT DELETED!"
      And on clicking continue user redirect to Landing Page
