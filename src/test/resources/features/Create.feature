Feature: Create users
  As: REQRES services consumer
  I want: To create some users
  So that

  Background: I am at Home Page
    Given I performed a GET request to Users page of REQRES
    And I changed the request method to POST

  Scenario Outline: Valid users
    When I add a valid JSON body
    And I use a '<name>' and '<job>' in it
    Then I will get a creation ID for '<name>' the '<job>'
    Examples:
      | name | job |
      | John | Doe |
      | Jane | Doe |
      | Mary | Sue |

  Scenario: Invalid users
    When I add an invalid JSON body
    Then I will get a Bad Request status