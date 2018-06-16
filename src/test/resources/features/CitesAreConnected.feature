Feature: Two cities are passed through an endpoint to see if they exist

  Scenario: Passing two cities in parameter which contains in a text file should return a yes
    Given the origin city and destination city
    When ConnectedController endpoint is executed with the origin city and destination city
    Then it should return a yes to client

  Scenario: Passing two cities in parameter which does not contain in a text file should return a no
    Given the wrong origin city and destination city
    When ConnectedController endpoint is executed with the wrong origin city and destination city
    Then it should return a no to client