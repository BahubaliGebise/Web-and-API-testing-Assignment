Feature:  Apply for auto quote service flow.

  @Regression
  Scenario: UC01 - Apply for auto quote service.
    Given the test case id is "UC01"
    When logic with valid user name
    * verify user login details
    And user select 'Auto quote' service
    Then user provide required details to purchase AutoQuote service
