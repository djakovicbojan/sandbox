@createUseCase
Feature: Create and edit test case

  Scenario Outline: Create new use cases and after that edit them with length of the previous one
    Given I log in as Djakovic Bojan
    When I create a <useCaseNumber> use cases
#    And I navigate to the <useCaseNumber> use case
    Then I edit <useCaseNumber> test case with length value
    Examples:
    | useCaseNumber |
    | 4             |