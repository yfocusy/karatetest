Feature: Karate for API testing.

  Scenario: Testing valid GET endpoint

    Given url 'http://localhost:8088/user/get'
    When method GET
    Then status 200

  Scenario: Testing the exact response of a GET endpoint

    Given url 'http://localhost:8088/user/get'
    When method GET
    Then status 200
    And match $ == {id:"user1", name:"Anna"}

  Scenario: Testing that GET response contains specific field

    Given url 'http://localhost:8088/user/get'
    When method GET
    Then status 200
    And match $ contains {id:"user1"}