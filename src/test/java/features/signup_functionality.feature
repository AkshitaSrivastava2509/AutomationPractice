Feature: Validating Signup functionality

  As a user
  I want to Signup in AutomationExercise website
  And I want to be notified when using an already registered email
  So that I cannot create a duplicate account

  Background:
    Given user is on Automation Exercise LandingPage
    And user click on Signup Login button

  @SignupTest @smoke @full
  Scenario: Verifying signup with new email
    When user enter new name "TestAuto245k" and email "cucumtest764876@example.com"
    And click on Signup button
    Then user should be navigate to Signup page

  @SignupTest @negative @full
  Scenario: Verifying signup with existing email
    When user enter name "TestAuto" and existing email "cucumbertest@example.com"
    And click on Signup button
    Then user should see error message
