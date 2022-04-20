@smoke

Feature: Smoke Test
  As a User
  I want to calculate from the browser
  So that I can calculate fast without a need of installing calculator


  @smoke-1
  Scenario: Smoke - Open Google calc and verify it is open
    Given I open a google calc page
    When Log 'first log' Message
    Then The Google calc page is open

  @smoke-2
  Scenario: Smoke - Log message
    Given Log 'second feature file test' Message