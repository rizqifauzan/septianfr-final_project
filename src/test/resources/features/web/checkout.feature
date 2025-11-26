@web
Feature: Checking Out the Item

  @checkout
  Scenario: Entering details in the checkout page
    Given the user is on the Checkout page
    When the user enter the details, first name "John", last name "Doe" and the zip code 12343
    And the user click the Continue button
    Then then the item has been successfully purchased, which the user will be redirected to the Checkout overview page