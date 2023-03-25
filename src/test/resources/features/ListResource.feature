Feature: List resources
  As: REQRES services consumer
  I want: To know the resources available in the service
  So that

  Background: I am at HomePage
    Given I performed a GET request to Home page of REQRES
    When I add a slug '/unknown' to URL
    And I perform the request again

  Scenario: Receive Body
    Then I will receive a JSON with available resources

  Scenario: Receive status code
    Then I will get an OK status