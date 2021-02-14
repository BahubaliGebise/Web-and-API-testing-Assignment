Feature:   UI Login validation.

  @Regression
  Scenario: UC03 -Validate user Login.

    Given the test case id is "UC03"
    When logic with valid user name
    Then verify user login details
