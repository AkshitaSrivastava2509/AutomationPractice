Feature:  Verifying the Login Functionality

  As a user of the Automation Exercise website
  I want to be able to login  with my account
  So that I can access my account-related detail and manage my orders


  Background:
    Given user is on Automation Exercise LandingPage
    And user click on Signup Login button

  @LoginTest @smoke @full
  Scenario: Login with valid credentials
    Given user enter valid  email "cucumbertest@example.com" and password "test@123"
    When user click on Login button
    Then user should be logged in successfully and see Logged in as username

  @LoginTest @negative @full
    Scenario Outline: Login with invalid credentials
      Given user enter invalid <email> and <password>
      When user click on Login button
      Then user should see error message <error_message>
      Examples:
        | email            | password | error_message                        |
        | te@test.com      | test     | Your email or password is incorrect! |
        | aabbsss@test.com | Test@125 | Your email or password is incorrect! |
        | test@123.com     | tesgg    | Your email or password is incorrect! |




