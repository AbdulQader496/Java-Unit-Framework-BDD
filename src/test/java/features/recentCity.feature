Feature: Recent City
  I am a User
  I want to see the weather of a recent/suggested city
  To be able to see the weather of that city

  Scenario: Choose recent city after search
    Given I go to the Main Page and I Consent data usage
    When I Enter "London" in search text box
    Then I choose the location from the list and the weather of London is displayed
    And I go back to Main page
    Then I choose the first city in the Recent location and the weather is displayed