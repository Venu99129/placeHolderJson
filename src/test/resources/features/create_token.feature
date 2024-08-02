Feature: Create Auth Token

  Scenario Outline: Verify user can create token
    Given set end point as "/auth"
    And set Header as "Content-Type" to "application/json"
    And set request body from the file with username "<username>" and password "<password>"
    When call the post method
    Then verify status code as 200
    And verify response message is "Bad credentials"

    Examples:
      | username | password    |
      | ADMIN    | ADMIN123    |
      | admin    | password123 |
      | Admin    | password123 |
      | aDMIN    | password123 |
      | admin    | Password    |