Feature: Search on Google

  Background: I am on the Google homepage
      Given Open the website
  Scenario: Perform search
  When I enter "Минск" into the search field
    When I submit the search
    Then I should see search results contains "Минск"  and "https://ru.wikipedia.org"
    Then I close browser

