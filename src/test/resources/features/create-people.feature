@people
  Feature: Create people

    Scenario: Create new people on a sandbox
      Given I log in as Djakovic Bojan
      When I create a 1 use cases
      And I navigate to the created use case
      Then I edit test case with length value
