Feature: New User sign up Test

  Scenario: As a new user I want to be able to sign up successfully
    Given I am on the Homepage
    And I click sign up
    And I enter all the sign up detail
    When I click on the Register link
    Then my acount is created
    And I click the FAQ link
    # And I search for Answers
    And close the browser
