Feature: test on json post call
  Scenario: create order post call
    Given set end point as "/posts"
    And set Header as "Content-Type" to "application/json"
    And set body as json file "create_order.json"
    When call the post method
    Then verify status code as 201
    Then verify id is not empty

    Given set end point as "/posts/@id"
    And set body is empty
    Then call get method
    Then verify status code as 201

    Given set end point as "/posts"
    Then call get method
    Then verify status code as 200
    And printing all order details


  Scenario: rest post request
    Given set end point as "/objects"
    And set Header as "Content-Type" to "application/json"
    And set body as json file "create_object.json"
    When call the post method
    Then verify status code as 200
    Then verify id is not empty

    Given set end point as "/objects/@id"
    And set body is empty
    Then call get method
    Then verify status code as 200
    Then compare request and response body




