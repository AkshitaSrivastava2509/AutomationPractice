Feature:  Verifying Product Page functionality

  As a user,
  I want to add multiple products to the cart and
  product should remain in the cart even if logged out.

  Background:
    Given user is on Automation Exercise LandingPage
    And   user click on Signup Login button


 @ProductTest @full
  Scenario: Search and add product with specific quantity
    Given user logged in with valid email "cucumbertest1@example.com" and password "1234"
    And    user navigate to Product page
    When user search for product "saree"
    Then search results should contain word "saree"
    When  user add product first product to the cart with quantity "2"
    And  user navigate to cart
    Then user should see quantity "2" for the added product


  @ProductTest @full
    Scenario: Add multiple products to the cart  and validate persistence
      Given  user logged in with valid email "cucumbertest@example.com" and password "test@1234"
      And   user navigate to Product page
      When  user added first product "Blue Top" to the carts
      And   click on Continue Shopping button
      And   add one more product "Winter Top" to the cart
      And   click on View Cart button
      Then  user should see both the  products in the cart
      And   cart should persist after refresh

  @ProductTest @full
  Scenario: Remove products from the cart
    Given user logged in with valid email "cucumbertest@example.com" and password "test@1234"
    And   user navigate to cartPage
    When  user click on delete all the products from the cart
    Then  user should see "Cart is empty! Click here to buy products." message



