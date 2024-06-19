Feature: Character Detail View
  As a user
  I want to get detailed information about a character by their ID
  So that I can see complete details of the character, including their name, status, species, gender, origin, location, image, and episodes they appear in.

  Scenario: Viewing details with valid ID
    Given the user is on the character detail page
    When the user enters the ID "1" in the input field
    And presses the search button
    Then the detailed information of the character is displayed
    And the information includes name, status, species, gender, origin, location, image, and episodes.

  Scenario: Viewing details with invalid ID
    Given the user is on the character detail page
    When the user enters the ID "9999" in the input field
    And presses the search button
    Then an error message indicating the ID is invalid is displayed.

  Scenario: Viewing details with non-existent ID
    Given the user is on the character detail page
    When the user enters the ID "123456" in the input field
    And presses the search button
    Then message indicating no results found is displayed.

  Scenario: Detail view performance
    Given the user is on the character detail page
    When the user enters the ID "1" in the input field
    And presses the search button
    Then the detailed information of the character is displayed in less than 2 seconds.