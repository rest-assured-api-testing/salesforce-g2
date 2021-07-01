Feature: Account
  @GetAccounts
  Scenario: Get all Accounts
    When I set the "/Account" endpoint and send the request
    Then the response status code should be "200"

  @CreateAccount
  Scenario Outline: Create an Account with name, account number, phone, type and rating
    Given I set the post request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
      | Type          | <typeAccount>   |
      | Rating        | <ratingAccount> |
    When I set the "/Account" endpoint and send the request with body
    Then the response status code should be "<status>"
    And Validate "responsetocreate" schema
    Examples:
      | nameAccount   | numberAccount | phoneAccount   | typeAccount        | ratingAccount | status |
      | New Account 0 | 1236978       | 78968900       | Prospect           | Hot           | 201    |
      | New Account 1 | 123           | 78969630       | Prospect           |               | 201    |
      | New Account 2 |               | 55587963       | Technology Partner |               | 201    |
      | New Account 3 |               |                |                    | Hot           | 201    |
      | New Account 4 | 245           | 87963645       |                    | Warm          | 201    |
      | New Account 5 |               | 85648982       |                    | Cold          | 201    |
      | New Account 6 |               | 85648982       | Customer - Direct  | Very Cold     | 201    |
      | New Account 7 |               | 85648982       | Customer - Channel | very Warm     | 201    |
      | New Account 8 |               |                |                    | Freeze        | 201    |
      | New Account 9 |               |                | My Prospect        |               | 201    |
      | New Account 1 |               |                | IA                 |               | 201    |
      | New Account 2 |               |                | --------------     |               | 201    |
      | New Account 3 | anyNumber     |                |                    |               | 201    |
      | New Account 4 |               | anyPhoneNumber |                    |               | 201    |
      | null          | null          | null           | null               | null          | 201    |
      | 1111111111111 |               |                |                    |               | 201    |

  @CreateAccount
  Scenario Outline: An Account with account number, phone, type, rating and null name shouldn't be created
    Given I set the post request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
      | Type          | <typeAccount>   |
      | Rating        | <ratingAccount> |
    When I set the "/Account" endpoint and send the request with body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount   | numberAccount | phoneAccount   | typeAccount        | ratingAccount | status |
      |               |               |                |                    |               | 400    |
      |               | 1236978       | 78968900       | Prospect           | Hot           | 400    |
      |               |               | 78968900       | Prospect           | Warm          | 400    |
      |               |               |                | Prospect           | Cold          | 400    |
      |               |               |                |                    | Hot           | 400    |

  @CreateAccount
  Scenario Outline: Create an Account with name, account number and phone
    Given I set the post request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
    When I set the "/Account" endpoint and send the request with body
    Then the response status code should be "<status>"
    And Validate "responsetocreate" schema
    Examples:
      | nameAccount | numberAccount | phoneAccount   | status |
      | New Account | 123           | 78969630       | 201    |
      | New Account |               | 55587963       | 201    |
      | New Account |               |                | 201    |
      | New Account | anyNumber     |                | 201    |
      | New Account |               | anyPhoneNumber | 201    |

  @CreateAccount
  Scenario Outline: An Account with account number, phone and null name shouldn't be created
    Given I set the post request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
    When I set the "/Account" endpoint and send the request with body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount | numberAccount | phoneAccount   | status |
      |             | 245           | 87963645       | 400    |
      |             |               | 85648982       | 400    |

  @GetAccount
  Scenario: Get an Account
    Given I set the "get" request
    When I set the "/Account/{id}" endpoint and send the request
    Then the response status code should be "200"
    And Validate "account" schema

  @UpdateAccount
  Scenario Outline: Update name, account number, phone, type and rating of an Account
    Given I set the update request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
      | Type          | <typeAccount>   |
      | Rating        | <ratingAccount> |
    When I set the "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount     | numberAccount | phoneAccount   | typeAccount        | ratingAccount | status |
      | Updated Account | 1236978       | 78968900       | Prospect           | Hot           | 204    |
      | Updated Account |               | 78969630       | Prospect           | Warm          | 204    |
      | Updated Account |               |                | Technology Partner | Cold          | 204    |
      | Updated Account |               |                |                    | Warm          | 204    |
      | Updated Account | 5698932       | 87963645       | Customer - Direct  |               | 204    |
      | Updated Account | 2455896       | 87963645       |                    |               | 204    |
      | Updated Account | 5559863       |                |                    | Cold          | 204    |
      | Updated Account |               |                |                    |               | 204    |
      | 123456789       |               |                |                    |               | 204    |
      | 1z1as5faf6asf   |               |                |                    |               | 204    |
      | Updated Account |               | 78962158       | My Prospect        |               | 204    |
      | Updated Account |               | 85879955       |                    | very Warm     | 204    |

  @UpdateAccount
  Scenario Outline: Account number, phone, type and rating shouldn't be updated with null name of an Account
    Given I set the update request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
      | Type          | <typeAccount>   |
      | Rating        | <ratingAccount> |
    When I set the "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount     | numberAccount | phoneAccount   | typeAccount        | ratingAccount | status |
      |                 | 1236978       | 78968900       | Prospect           | Hot           | 400    |
      |                 |               | 78969630       | Prospect           | Warm          | 400    |
      |                 |               |                | Technology Partner | Cold          | 400    |
      |                 |               |                |                    | Warm          | 400    |
      |                 | 5698932       | 87963645       | Customer - Direct  |               | 400    |
      |                 | 2455896       | 87963645       |                    |               | 400    |
      |                 | 5559863       |                |                    | Cold          | 400    |
      |                 |               |                |                    |               | 400    |

  @UpdateAccount
  Scenario Outline: Update name, account number and phone of an Account
    Given I set the update request
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

  @UpdateAccount
  Scenario Outline: Account number and phone shouldn't be updated with null name of an Account
    Given I set the update request
      | name          | <nameAccount>   |
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
    When I set the "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount     | numberAccount | phoneAccount | status |
      |                 | 245           | 87963645     | 400    |
      |                 |               | 85648982     | 400    |
      |                 |               |              | 400    |

  @UpdateAccount
  Scenario Outline: Update number and phone of an Account
    Given I set the update request
      | AccountNumber | <numberAccount> |
      | Phone         | <phoneAccount>  |
    When I set the "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | numberAccount | phoneAccount | status |
      |               |              | 204    |
      | 123           |              | 204    |
      | 686           | 87961331     | 204    |
      | 245           | 87963645     | 204    |
      |               | 85648982     | 204    |
      |               |              | 204    |

  @UpdateAccount
  Scenario Outline: Name shouldn't be updated with a created date of an Account
    Given I set the update request
      | name        | <nameAccount>         |
      | CreatedDate | <createdDateAccount>  |
    When I set the "/Account/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | nameAccount     | createdDateAccount             | status |
      |                 | "2021-06-15T21:25:28.000+0000" | 400    |
      | Updated Account | "2021-06-30T21:25:28.000+0000" | 400    |
      |                 |                                | 400    |


  @DeleteAccount
  Scenario: Delete an Account
    Given I set the "delete" request
    When I send "/Account/{id}" delete request
    Then the response status code should be "204"
