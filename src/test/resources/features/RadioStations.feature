@station
Feature: Radio Stations

  Background: User starts the car and disables full screen mode from radio settings
    Given all popups are closed after startup
    And media source menu is opened
    And radio is selected from media source
    And radio screen components are visible
    And User taps over radio settings button
    And User disables full screen mode from radio settings
    And User closes radio settings screen
#
  Scenario: List of Stations - UI Elements
    When The list os stations is visible
#    Then User should all stations in the list
#    And Logo should be displayed right to the Hamburger Menu Icon at top left
