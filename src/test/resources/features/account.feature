Feature: Requests for Account endpoint
  @GetAccounts
  Scenario: Get all Accounts
    Given
    When I add this "/Account" endpoint and send the request
    Then the response status code should be "200"

  @CreateAccount
  Scenario Outline: Create a Account
    Given I build the pathParams and body to request
      | name  | <nameAccount> |
    When I add this "/Account" endpoint and send the request with body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount | status |
      | New Account | 201    |

  @GetAccount
  Scenario: Get a Account
    Given I build the pathParams to request
    When I add this "/Account/{id}" endpoint and send the request
    Then the response status code should be "200"

  @UpdateAccount
  Scenario Outline: Update a Account
    Given I build the pathParams and updated body to request
      | name  | <nameAccount> |
    When I add this "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "204"
    Examples:
      | nameAccount         |
      | Updated Account     |

  @DeleteAccount
  Scenario: Delete a Account
    Given I build the pathParams to request
    When I add this "/Account/{id}" endpoint and send the delete request
    Then the response status code should be "204"