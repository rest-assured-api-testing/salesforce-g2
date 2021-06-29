Feature: Requests for Account endpoint
  @GetAccounts
  Scenario: Get all Accounts
    Given
    When I set the "/Account" endpoint and send the request
    Then the response status code should be "200"

  @CreateAccount
  Scenario Outline: Create a Account
    Given I set the pathParams and body to request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
    When I set the "/Account" endpoint and send the request with body
    Then the response status code should be "<status>" with the "responsetocreate" schema
    Examples:
      | nameAccount | numberAccount | phoneAccount | status |
      | New Account | 123           | 78969630     | 201    |
      | New Account |               | 55587963     | 201    |
      | New Account |               |              | 201    |
      |             | 245           | 87963645     | 400    |
      |             |               | 85648982     | 400    |
      |             |               |              | 400    |

  @GetAccount
  Scenario: Get a Account
    Given I set the pathParams to request
    When I set the "/Account/{id}" endpoint and send the request
    Then the response status code should be "200" with the "account" schema

  @UpdateAccount
  Scenario Outline: Update a Account
    Given I set the pathParams and updated body to request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
    When I set the "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount     | numberAccount | phoneAccount | status |
      | Updated Account |               |              | 204    |
      | Updated Account | 123           |              | 204    |
      | Updated Account | 686           | 87961331     | 204    |
      |                 | 245           | 87963645     | 400    |
      |                 |               | 85648982     | 400    |
      |                 |               |              | 400    |

  @UpdateAccount
  Scenario Outline: Update a Account
    Given I set the pathParams and updated body to request
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
    When I set the "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | numberAccount | phoneAccount | status |
#      |               |              | 204    |
#      | 123           |              | 204    |
#      | 686           | 87961331     | 204    |
      | 245           | 87963645     | 204    |
#      |               | 85648982     | 204    |
#      |               |              | 204    |
  @DeleteAccount
  Scenario: Delete a Account
    Given I set the pathParams to request
    When I set the "/Account/{id}" endpoint and send the delete request
    Then the response status code should be "204"
