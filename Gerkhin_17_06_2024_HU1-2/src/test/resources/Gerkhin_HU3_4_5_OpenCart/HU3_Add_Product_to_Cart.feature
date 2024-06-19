Feature: Add Product to Cart
  As a customer
  I want to add products to my shopping cart from any page of the store
  So that I can easily manage my purchases

  Scenario: Adding a product to the cart
    Given the user is on any product page
    When the user clicks on the "Add to Cart" button
    Then the product is added to the cart
    And a confirmation message is displayed indicating the product has been added to the cart
    And the number of items in the cart is updated automatically
    And the total amount in the cart is updated automatically