Feature: Update resource
  As: JSONPlaceholder services consumer
  I want: To update a resource
  So that

  Scenario: Update a resource
    Given I have access to JSONPlaceholder the server
    When I update an existing resource via a Put request
    Then I will get a JSON object with the new body