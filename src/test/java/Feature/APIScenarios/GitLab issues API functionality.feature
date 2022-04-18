Feature:  GITLAB API issues test collection

  Background:
      Given that the base URL of "API" is set


  @API
  Scenario: Fetch the newly created project details

    When executing GET call to fetch project details
    Then a status code "200" response is returned
    And verify project details from response

  @API
  Scenario: Create a issue on newly created project

    When executing POST call to create new issue
    Then a status code "201" response is returned
    And verify TITLE new value from response


  @API
  Scenario Outline: Update a issue on newly created project

    When executing PUT call to update the issue by providing the "<project_number>" and "<issue_number>"
    Then a status code "200" response is returned
    And verify Description and IssueType value from response
    Examples:
    |project_number     | issue_number |
    | /35418729/issues/ | 5            |


  @API
  Scenario: Delete an issue and confirm with GET method that a issue has been DELETED successfully

   # create issue
    When executing POST call to create new issue
    Then fetch newly created iid from response and set data for delete
  # Delete same newly created issue
    When executing DELETE call to delete an issue
    Then a status code "204" response is returned
   # Confirm deleted issue
    And execute GET call to verify issue has been deleted
    And a status code "404" response is returned


  @API
  Scenario Outline: Update an issue, but the issue number is already deleted

    When executing POST call to create new issue
    Then fetch newly created iid from response and set data for delete

  # Delete same newly created issue
    When executing DELETE call to delete an issue
    Then a status code "204" response is returned

  # On Deleted issue , we are trying to update values
    When executing PUT call to update the issue by providing the "<project_number>"
    Then a status code "404" response is returned

    And execute GET call to verify issue has been deleted
    And a status code "404" response is returned
    Examples:
      |project_number     |
      | /35418729/issues/ |

