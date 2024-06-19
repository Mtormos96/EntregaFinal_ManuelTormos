Feature: Rick and Morty Character Search
  As a user
  I want to search for Rick and Morty characters by name
  So that I can get detailed information about them, including their name, status, location, image, and episodes they appear in.

  Scenario: Search with full name
    Given the user is on the character search page
    When the user enters "Rick Sanchez" in the search field
    And presses the search button
    Then the search results are displayed
    And the first result includes "Rick Sanchez"
    And the result shows the name, image, status, location, and episodes.

  Scenario: Search with partial name
    Given the user is on the character search page
    When the user enters "Rick" in the search field
    And presses the search button
    Then the search results are displayed
    And one of the results includes "Rick Sanchez"
    And the result shows the name, image, status, location, and episodes.

  Scenario: Search with incomplete name without exact matches
    Given the user is on the character search page
    When the user enters "Rck" in the search field
    And presses the search button
    Then similar name suggestions are displayed
    And a message indicating no exact matches is shown.

  Scenario: Search with no results
    Given the user is on the character search page
    When the user enters "NonexistentName" in the search field
    And presses the search button
    Then a message indicating no results found is displayed
    And alternative search suggestions are shown.

  Scenario: Search performance
    Given the user is on the character search page
    When the user enters "Rick" in the search field
    And presses the search button
    Then the search results are displayed in less than 2 seconds.