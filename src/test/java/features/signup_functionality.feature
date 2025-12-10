Feature: Validating Signup functionality

    As a user,
    I want to Signup in AutomationExercise website,
    and I want to be notified when using an already registered email,
    so that I cannot create a duplicate account

  Background:
    Given User is on Automation Exercise LandingPage

    @SignupTest
  Scenario: Verifying signup with new email
    Given  user click on Signup Login button
    And   user enter new "TestAuto245k" and "cucumtest764876@example.com"
    When    user click on Signup button
    Then   user should be navigate to Signup page


      @SignupTest
  Scenario: Verifying signup with existing email
      Given user click on Signup Login button
      And   user enter name  "TestAuto" and existing email "cucumbertest@example.com"
      When   user click on Signup button
      Then  user should see error message



