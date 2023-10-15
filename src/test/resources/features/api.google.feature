Feature: Api search in Google

  Background: I contact with Api

  Scenario: perform api google search
    When I seng get-request to  "https://www.google.com/?search=Minsk"
    Then I received response with Status code 200

