Feature: Requests for Account endpoint
  @GetAccounts
  Scenario: Get all Accounts
    Given I build a all get account request "GET"
    When I add this "/Account" endpoint and execute all get account request
    Then the response status code should be "200" to all get account request

  @CreateAccount
  Scenario: Create a Account
    Given I build a post account request "POST"
    When I add this "/Account" endpoint and execute post account request
    Then the response status code should be "201" to post account request

  @GetAccount
  Scenario: Get a Account
    Given I build a get account request "GET"
    When I add this "/Account/{id}" endpoint and execute get account request
    Then the response status code should be "200" to get account request

  @UpdateAccount
  Scenario: Update a Account
    Given I build a update account request "PATCH"
    When I add this "/Account/{id}" endpoint and execute patch account request
    Then the response status code should be "204" to patch account request

  @DeleteAccount
  Scenario: Delete a Account
    Given I build a delete account request "DELETE"
    When I add this "/Account/{id}" endpoint and execute delete account request
    Then the response status code should be "204" to delete account request