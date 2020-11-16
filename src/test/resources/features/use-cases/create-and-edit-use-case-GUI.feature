@gui
Feature: Create and edit test case GUI

  Scenario: Create new use cases and after that edit them with length of the previous one GUI
    Given User is logged in
    When User creates 4 new use cases
    Then User edit 4 use cases previously created