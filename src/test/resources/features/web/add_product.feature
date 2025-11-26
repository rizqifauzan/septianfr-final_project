@web
Feature: Add Product

  @inventory
  Scenario: Adding a product to cart
    Given the user is on the inventory page
    When the user click the Add to Cart button for "Sauce Labs Backpack"
    Then the item should be added to the cart, which the cart badge should show "1"