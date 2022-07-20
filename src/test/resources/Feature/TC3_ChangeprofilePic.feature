@ChangeProfilepic
Feature: ChangeProfilepic module API automation

  Scenario: Verify to ChangeProfilepic to the application through API
    Given User add headers and bearer authorization and multipart/form-data for accessing ChangeProfilepic endpoints
    When User send "POST" request for ChangeProfilepic
    Then User verify the status code is 200
    And User verify the ChangeProfilepic response messagematches 'Profile updated Successfully'
