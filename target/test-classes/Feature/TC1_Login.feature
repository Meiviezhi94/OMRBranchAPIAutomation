@Login
Feature: Login module API automation

  Scenario: Get user logtoken from login endpoint
    Given User add header
    And User add basic authentication for login
    When user send "POST" request for login endpoint
    Then User verify the status code is 200
    And User verify the login response body firstname present as "Meiviezhi" and get the logtoken
