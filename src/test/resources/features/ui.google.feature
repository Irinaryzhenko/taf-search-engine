Feature: Search on Google

  Background: I am on the Google homepage
      Given Open the website
  Scenario: Perform search
  When I enter "Minsk" into the search field
    When I submit the search
    Then I should see search results contains "Wikipedia, wolna encyklopedia"  and "https://pl.wikipedia.org"
    Then I close browser

