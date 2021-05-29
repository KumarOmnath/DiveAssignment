@dive_Assignment
Feature: Open Rume website & check with 8 participant

  Scenario: Verify Rume website 8 participant able to join call
    Given Load the browser and Navigate to URL
    When User click on start a rume
    And Enter Host name in field
    And User navigated to home page
    And  User validate Audio & Vidio is enabled
    And Host Share link to 8 participant & validate participant ablr to join
    Then Validate switch to  Host & check  all 8 participant  is joined or not
