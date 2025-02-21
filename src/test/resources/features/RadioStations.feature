@station
Feature: Radio Stations

  Background: User starts the car and disables full screen mode from radio settings
#    Given all popups are closed after startup
    Given media source menu is opened
    And radio is selected from media source
    And radio screen components are visible
    And User taps over radio settings button
    And User disables full screen mode from radio settings
    And User closes radio settings screen

  @IDCEVODEV-22947
  Scenario: [Tuner] DAB - All stations list
    Given the media source is "radio"
    When selecting "any" station from the stations list
    Then the "current" station is audible
    And the "current" information is updated
    When scrolling from top to bottom through the all stations list
#    Then the list contains currently receivable DAB and for each station,
#    And the information about the corresponding bearer (DAB) is indicated with an icon or Albumcover.

  @IDCEVODEV-22947
  Scenario: DAB stations list - skip to other station using media mini player
    Given the media mini player is visible
    And the list of stations is at the beginning
    When selecting "any" station from the stations list
    And waits for 3 seconds
    Then the "current" station is audible
    And the "current" information is updated
    When pressing right skip button on Media Mini Player
    Then the next station in the list is selected
    Then the "next" station is audible
    And the "next" information is updated
    When pressing the left skip button in Media Mini Player
    Then the previous station in the list is selected
    And the "previous" station is audible
    And the "previous" information is updated
    When repeating the skip to the right actions 10 times
    And waits for 3 seconds
    Then the "current" station is audible
    And the "current" information is updated