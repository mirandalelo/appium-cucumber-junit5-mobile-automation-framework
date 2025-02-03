@station
Feature: Radio Stations

  Background: User is on Radio Home Page
    Given User taps over radio settings button
    And User disables full screen mode from radio settings
    And User closes radio settings screen

  Scenario: List of Stations - UI Elements
    When The list os stations is visible
    Then User should all stations in the list
#    And Logo should be displayed right to the Hamburger Menu Icon at top left
