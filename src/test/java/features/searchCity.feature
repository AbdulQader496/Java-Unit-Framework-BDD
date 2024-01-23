Feature: Search City
  I am a User
  I want to search the weather of a city
  To be able to see the weather of searched city

  Scenario: Enter the name of the city
    Given I go to the Main Page and I Consent data usage
    When Enter "New York" in search text box
    Then I choose the location from the list and the weather of New York is displayed