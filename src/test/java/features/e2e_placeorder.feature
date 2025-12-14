Feature: Verify End to end functionality

  As a user,
  I want to buy products from the website

  Background:
  Given user is on Automation Exercise LandingPage

@E2E @regression @full
  Scenario Outline: Place a complete order by registering during checkout
    Given user added product "<Product1>" and "<Product2>" to the cart
    When user open the cart and clicks proceed to checkout
    And user choose to register or login with credential "<name>" and "<email>"
    And user completes account registration with the following details
      | name       | email              | password | firstName | lastName | company | address1        | address2 | country | state   | city    | zipcode | mobileNumber |
      | <name>     | <email>            | 1234     | John      | Doe      | ABC Inc | Street No 123   | Apt 1    | India   | Delhi   | Delhi   | 110001  | 9876543210   |
    Then user should see Account Created confirmation
    When user clicks Continue after registration
    And user goes to cart and proceeds to checkout
    And user enters delivery address
    And user enters payment details
      | cardName     | cardNumber     | cvc | expiryMonth | expiryYear |
      | <name>       | 4111111111111111 | 123 | 12         | 2030       |
    And user places the order
    Then user should see order success message "ORDER PLACED!"

    Examples:
      | Product1   | Product2         | name         | email                        |
      | Men Tshirt | Sleeveless Dress | TestUserNew22 | testusernewreg22@example.com |

@E2E @regression @full
Scenario Outline: Place a complete order by login before checkout

  Given  user click on Signup Login button
  And   user logged in with valid email "cucumbertest@example.com" and password "test@123"
  And user added product "<Product1>" and "<Product2>" to the cart
  When user open the cart and clicks proceed to checkout
  And user enters delivery address
  And user enters payment details
    | cardName     | cardNumber       | cvc | expiryMonth | expiryYear |
    | cucumbertest | 4111111111111111 | 123 | 12          | 2030       |
  And user places the order
  Then user should see order success message "ORDER PLACED!"

  Examples:
    | Product1   | Product2         |
    | Men Tshirt | Sleeveless Dress |