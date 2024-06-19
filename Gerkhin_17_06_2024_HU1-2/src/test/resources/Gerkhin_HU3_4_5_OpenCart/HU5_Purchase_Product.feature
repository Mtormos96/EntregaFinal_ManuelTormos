Feature: Purchase Product
  As a customer
  I want to purchase an iPhone and an Apple Cinema 30" monitor
  So that I can complete my desired purchases

  Scenario: Completing the purchase
    Given the user has an iPhone and an Apple Cinema 30" monitor in the cart
    When the user proceeds to checkout
    And completes the purchase process
    Then a confirmation message is displayed indicating the products have been purchased successfully