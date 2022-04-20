@regression

Feature: Smoke Test
  As a User
  I want to use Google services
  So that I can spend less time on other important activities


  @regression-1
  Scenario: Smoke - Open Google calc and verify it is open
    Given I open a google calc page
    When Log 'first log' Message
    Then The Google calc page is open

  @regression-2
  Scenario: Smoke - Log message
    Given Log 'second feature file test' Message

  @regression-3
  Scenario: Smoke - [Broken] - Shows an intended broken test
    Given I open a google calc page
    Then The Google Unit Converter page is open

  @regression-4
  Scenario: Smoke - [Defect] - Shows an intended assertion failure
    Given I open a google calc page
    Then The Google calc page is not open