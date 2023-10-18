Feature: Search on Google

  Background: I am on the Google homepage

  @smoke
  Scenario: Perform search
    Given Open the website
    When I enter "Минск" into the search field
    When I submit the search
    Then I should see search results contains "Минск"  and "https://ru.wikipedia.org"


