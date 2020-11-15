@createUseCase @api
Feature: Create and edit test case API

  Scenario Outline: Create new use cases and after that edit them with length of the previous one API
    Given I log in as Djakovic Bojan
    When I create a <useCaseNumber> use cases
    Then I edit <useCaseNumber> test case with length value
    Examples:
    | useCaseNumber |
    | 4             |