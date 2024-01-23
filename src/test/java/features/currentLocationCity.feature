Feature: current location
  I am a User
  I want to see the weather using location
  To be able to see the weather of that location/city

  Scenario: Check if the use your location is displayed
    Given I go to the Main Page and I Consent data usage
    When I click on the search text box
    Then I will see the use you current location option