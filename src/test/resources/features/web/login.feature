@web
Feature: Login

  Scenario: Login with valid data
    Given the user is on the login page
    When the user input valid username "standard_user" and password "secret_sauce"
    And the user click the login button
    Then the user successfully login to the inventory page

  Scenario: Login with invalid data
    Given the user is on the login page
    When the user input invalid username "standard_user" and password "secret"
    And the user click the login button
    Then the user will see an error message "username and password do not match"

  Scenario: Login with empty username
    Given the user is on the login page
    When the user leave the username empty and password "secret_sauce"
    And the user click the login button
    Then the user will see an error message "Username is required"