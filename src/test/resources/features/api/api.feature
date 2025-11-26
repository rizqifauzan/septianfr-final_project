@api
Feature: API Test

  Scenario: Post valid data
    Given the base URL is "https://dummyapi.io/data/v1"
    When I send a POST request to "/user/create" with the following data, firstName "John", lastName "Doe"
    Then the response status code should be 200
    And the response body should contain id

  Scenario: Post boundary data
    Given the base URL is "https://dummyapi.io/data/v1"
    When I send a boundary POST request to "/user/create" with the following data, firstName "", lastName "Doe"
    Then the response status code should be 400

  Scenario: Get invalid data
    Given the base URL is "https://dummyapi.io/data/v1"
    When I send a GET request to "/user/123192nswaS12"
    Then the response status code should be 400

  Scenario: Update user data
    Given the base URL is "https://dummyapi.io/data/v1"
    When I send am PUT request to "/user/6906293e11611e00f239f25c" and update the firstName to "Johnny"
    Then the response status code should be 200
    And the response firstName should be "Johnny"

  Scenario: Invalid appId
    Given the base URL is "https://dummyapi.io/data/v1"
    When I send a GET request to "/post" with an invalid appId
    Then the response status code should be 403


