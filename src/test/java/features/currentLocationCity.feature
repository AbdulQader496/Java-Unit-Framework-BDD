Feature: current location
  I am a User
  I want to see the weather using location
  To be able to see the weather of that location/city

  Scenario: Check if the use your location is displayed
    Given I Consent to data usage
    When I click on the search field
    Then Search results list is displayed
    Then Use your current location label is displayed