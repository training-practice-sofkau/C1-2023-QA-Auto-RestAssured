Feature: Create resource
  As: JSONPlaceholder services consumer
  I want: To create a resource
  So that

  Scenario: Create a resource
    Given I have access to JSONPlaceholder server
    When I create a valid resource via a Post request
    Then I will get a JSON object with the same title