@web
Feature: Proceed Checkout From Cart Page

  @cart
  Scenario: Checking Out an Item
    Given the user is in the Cart page, with "1" item in the cart
    When the user click the Checkout button
    Then the user will be redirected to the first Checkout page