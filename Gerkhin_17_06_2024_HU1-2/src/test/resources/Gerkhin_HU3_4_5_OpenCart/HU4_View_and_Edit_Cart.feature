Feature: View and Edit Cart
  As a customer
  I want to view the contents of my shopping cart at any time
  So that I can review and modify my purchases

  Scenario: Viewing the cart contents
    Given the user is on the cart page
    Then the user should see a list of products in the cart with their names, images, prices, quantities, and subtotal

  Scenario: Removing a product from the cart
    Given the user is on the cart page
    When the user clicks on the "Remove" button next to a product
    Then the product is removed from the cart
    And the total amount in the cart is updated automatically

  Scenario: Updating product quantities in the cart
    Given the user is on the cart page
    When the user changes the quantity of a product in the cart
    And the user clicks on the "Update" button
    Then the quantity of the product is updated in the cart
    And the total amount in the cart is updated automatically