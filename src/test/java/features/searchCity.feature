Feature: Search City
  I am a User
  I want to search the weather of a city
  To be able to see the weather of searched city

  Scenario: Enter the name of the city
    Given I Consent to data usage
    When Enter "New York" in search field
    Then Search result is displayed
    When Click on the first search result
    Then City weather page header contains city name from the search