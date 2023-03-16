Feature: List resources
  As: REQRES services consumer
  I want: To know the resources available in the service
  So that

  Scenario:
    Given I performed a GET request to HomePage of REQRES
    When I add a slug '/unknown' to URL
    And I perform the request again
    Then I will receive a JSON with available resources