Feature: Requests for Account endpoint
  @GetAccounts
  Scenario: Get all Accounts
    Given
    When I add this "/Account" endpoint and execute "GETACCOUNTS" request
    Then the response status code should be "200" to "THENACCOUNTS" request

  @CreateAccount
  Scenario: Create a Account
    Given I build "GIVENCREATEACCOUNT" request
    When I add this "/Account" endpoint and execute "POSTACCOUNT" request
    Then the response status code should be "201" to "THENACCOUNTS" request

  @GetAccount
  Scenario: Get a Account
    Given I build "GIVENGETDELETEACCOUNT" request
    When I add this "/Account/{id}" endpoint and execute "GETACCOUNTS" request
    Then the response status code should be "200" to "THENACCOUNTS" request

  @UpdateAccount
  Scenario: Update a Account
    Given I build "GIVENUPDATEACCOUNT" request
    When I add this "/Account/{id}" endpoint and execute "PATCHACCOUNT" request
    Then the response status code should be "204" to "THENACCOUNTS" request

  @DeleteAccount
  Scenario: Delete a Account
    Given I build "GIVENGETDELETEACCOUNT" request
    When I add this "/Account/{id}" endpoint and execute "DELETEACCOUNT" request
    Then the response status code should be "204" to "THENACCOUNTS" request