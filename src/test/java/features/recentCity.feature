Feature: Recent City
  I am a User
  I want to see the weather of a recent/suggested city
  To be able to see the weather of that city

  Scenario: Choose recent city after search
    Given I Consent to data usage
    When I Enter "London" in search text box
    Then I Click on the first result
    And I go back to Main page
    Then main page is displayed
    When I choose the first city in the Recent location
    Then City weather page header contains city name from the Recent search