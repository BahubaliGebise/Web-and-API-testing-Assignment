Feature:  Contact us flow.

  @Regression
  Scenario: UC02 - contact us flow.
    Given the test case id is "UC02"
    When logic with valid user name
    * verify user login details
    And user select 'Auto quote' service
    Then provide contact us flow details


