Feature:  Fetch a list of Users on a page.

  @Regression
  Scenario: UC06-Fetch a list of Users on a page.
    Given the test case id is "UC06"
    Then user fetch list of users on a page and verify status code "200"
