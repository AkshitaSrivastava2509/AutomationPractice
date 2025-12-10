Feature:  Verifying Product Page functionality

  As a user,
  I want to add multiple products to the cart and
  product should remain in the cart even if logged out.

  Background:
    Given User is on Automation Exercise LandingPage
    And user click on Signup Login button


    @ProductTest
    Scenario: Add multiple products to the cart  and validate persistence
      Given user should be logged in with valid credential
        | username                 | password |
        | cucumbertest@example.com | test@123 |
      And user should be navigate to product page
      When user added first product "Blue Top" to the carts
      And  click on Continue Shopping button
      And   add one more product "Winter Top" to the cart
      And  click on View Cart button
      Then user should see both the  products in the cart
      And cart should persist after refresh


