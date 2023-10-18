Feature: Api search in Google

  Background: I contact with Api

  @smoke
  Scenario: perform api google search
    When I seng get-request to  "https://www.google.com/?search=Minsk"
    Then I received response with Status code 200
    Then Response contains "Minsk"

