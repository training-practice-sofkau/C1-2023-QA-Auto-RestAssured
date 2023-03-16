Feature: Dummy Rest API Functionality Scenarios

  Scenario Outline: Dummy Rest Api GET Students
    Given Get Call to "<url>"
    Then Response Code "<responseMessage>" is validated

    Examples:
      | url      | responseMessage |
      | /api/users | 200             |


