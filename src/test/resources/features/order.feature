Feature: Order endpoint tests

  @CreateOrder
  Scenario Outline: Create an Order with name, effectiveDate and status fields
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | name          | <name>          |
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | name                                                                              | effectiveDate | status | expectedStatus |
      | order                                                                             | 2022-01-01    | draft  | 201            |
      | 01234567890order                                                                  | 2022-01-01    | draft  | 201            |
      |                                                                                   | 2022-01-01    | draft  | 201            |
      | null                                                                              | 2022-01-01    | draft  | 201            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 201            |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |
      | order                                                                             | 2021-08-06    | draft  | 201            |
      | order                                                                             | 2021-88-06    | draft  | 201            |
      | order                                                                             | 2021-08-99    | draft  | 201            |
      | order                                                                             | 2021-00-01    | draft  | 201            |
      | order                                                                             | 2021-01-00    | draft  | 201            |
      | order                                                                             | 05-04-2021    | draft  | 400            |
      | order                                                                             | someDate      | draft  | 400            |
      | order                                                                             |               | draft  | 400            |
      | order                                                                             | null          | draft  | 400            |
      | order                                                                             | 2022-01-01    | other  | 400            |
      | order                                                                             | 2022-01-01    | 1      | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with description value
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | description   | <description>   |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | description                                                                                                                                                                                                                                                                                                                                                                                                            | effectiveDate | status | expectedStatus |
      | description                                                                                                                                                                                                                                                                                                                                                                                                            | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                                                                                                                                                                                                                                                                                                                                                                    | 2022-01-01    | draft  | 201            |
      |                                                                                                                                                                                                                                                                                                                                                                                                                        | 2022-01-01    | draft  | 201            |
      | null                                                                                                                                                                                                                                                                                                                                                                                                                   | 2022-01-01    | draft  | 201            |
      | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjkl12345  | 2022-01-01    | draft  | 201            |
      | 256charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjkl123456 | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingStreet value
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingStreet | <billingStreet> |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingStreet                                                                                                                                                                                                                                                                                                                                                                                                          | effectiveDate | status | expectedStatus |
      | anystreet                                                                                                                                                                                                                                                                                                                                                                                                              | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                                                                                                                                                                                                                                                                                                                                                                    | 2022-01-01    | draft  | 201            |
      |                                                                                                                                                                                                                                                                                                                                                                                                                        | 2022-01-01    | draft  | 201            |
      | null                                                                                                                                                                                                                                                                                                                                                                                                                   | 2022-01-01    | draft  | 201            |
      | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjkl12345  | 2022-01-01    | draft  | 201            |
      | 256charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjkl123456 | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingCity value
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingCity   | <billingCity>   |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingCity                               | effectiveDate | status | expectedStatus |
      | anyCity                                   | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                       | 2022-01-01    | draft  | 201            |
      |                                           | 2022-01-01    | draft  | 201            |
      | null                                      | 2022-01-01    | draft  | 201            |
      | 40chartextasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 201            |
      | 41chartextasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingState value
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingState  | <billingState>  |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingState                                                                      | effectiveDate | status | expectedStatus |
      | anyState                                                                          | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                               | 2022-01-01    | draft  | 201            |
      |                                                                                   | 2022-01-01    | draft  | 201            |
      | null                                                                              | 2022-01-01    | draft  | 201            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 201            |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingPostalCode value
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingPostalCode   | <billingPostalCode>   |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingPostalCode     | effectiveDate | status | expectedStatus |
      | anyPostalCode         | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><   | 2022-01-01    | draft  | 201            |
      |                       | 2022-01-01    | draft  | 201            |
      | null                  | 2022-01-01    | draft  | 201            |
      | 20chartextasdfghjklm  | 2022-01-01    | draft  | 201            |
      | 21chartextasdfghjklma | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingCountry value
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingCountry   | <billingCountry>   |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingCountry                                                                    | effectiveDate | status | expectedStatus |
      | anyPostalCode                                                                     | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                               | 2022-01-01    | draft  | 201            |
      |                                                                                   | 2022-01-01    | draft  | 201            |
      | null                                                                              | 2022-01-01    | draft  | 201            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 201            |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with poNumber value
    Given I set the pathParams and body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | poNumber   | <poNumber>   |
    When I set the "/Order" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | poNumber                                                                          | effectiveDate | status | expectedStatus |
      | anyPoNumber                                                                       | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                               | 2022-01-01    | draft  | 201            |
      |                                                                                   | 2022-01-01    | draft  | 201            |
      | null                                                                              | 2022-01-01    | draft  | 201            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 201            |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's name, effectiveDate and status fields.
    Given I set the pathParams and updated body with the requisite key "accountId" for the request
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | name          | <name>          |
    When I set the "/Order/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | name                                                                              | effectiveDate | status | expectedStatus |
      | order                                                                             | 2022-01-01    | draft  | 204            |
      | 01234567890order                                                                  | 2022-01-01    | draft  | 204            |
      |                                                                                   | 2022-01-01    | draft  | 204            |
      | null                                                                              | 2022-01-01    | draft  | 204            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 204            |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |
      | order                                                                             | 2021-08-06    | draft  | 201            |
      | order                                                                             | 2021-88-06    | draft  | 201            |
      | order                                                                             | 2021-08-99    | draft  | 201            |
      | order                                                                             | 2021-00-01    | draft  | 201            |
      | order                                                                             | 2021-01-00    | draft  | 201            |
      | order                                                                             | 05-04-2021    | draft  | 400            |
      | order                                                                             | someDate      | draft  | 400            |
      | order                                                                             |               | draft  | 400            |
      | order                                                                             | null          | draft  | 400            |
      | order                                                                             | 2022-01-01    | other  | 400            |
      | order                                                                             | 2022-01-01    | 1      | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's date fields.
    Given I set the pathParams and updated body with the requisite key "accountId" for the request
      | effectiveDate          | <effectiveDate>          |
      | endDate                | <endDate>                |
      | poDate                 | <poDate>                 |
      | customerAuthorizedDate | <customerAuthorizedDate> |
      | companyAuthorizedDate  | <companyAuthorizedDate>  |
    When I set the "/Order/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | effectiveDate | endDate    | poDate     | customerAuthorizedDate | companyAuthorizedDate | expectedStatus |
      | 2021-88-06    | null       | null       | null                   | null                  | 204            |
      | 2021-08-99    | null       | null       | null                   | null                  | 204            |
      | 1700-01-01    | null       | null       | null                   | null                  | 204            |
      | 1699-12-30    | null       | null       | null                   | null                  | 400            |
      | 05-04-2021    | null       | null       | null                   | null                  | 400            |
      | someDate      | null       | null       | null                   | null                  | 400            |
      |               | null       | null       | null                   | null                  | 400            |
      | null          |            | null       | null                   | null                  | 400            |
      | 2022-01-01    | 2022-01-01 | null       | null                   | null                  | 204            |
      | 2021-01-01    | 2020-01-01 | null       | null                   | null                  | 400            |
      | 1700-01-01    | 1700-01-01 | null       | null                   | null                  | 204            |
      | 1699-12-30    | 1699-12-30 | null       | null                   | null                  | 400            |
      | 2021-01-01    | 05-04-2021 | null       | null                   | null                  | 400            |
      | 2021-01-01    | someDate   | null       | null                   | null                  | 400            |
      | 2021-01-01    |            | null       | null                   | null                  | 204            |
      | 2021-01-01    | null       | null       | null                   | null                  | 204            |
      | 2021-01-01    | null       | 1700       | null                   | null                  | 204            |
      | 2021-01-01    | null       | 1699       | null                   | null                  | 400            |
      | 2021-01-01    | null       | 05-04-2021 | null                   | null                  | 400            |
      | 2021-01-01    | null       | some       | null                   | null                  | 400            |
      | 2021-01-01    | null       |            | null                   | null                  | 204            |
      | 2021-01-01    | null       | null       | null                   | null                  | 204            |
      | 2021-01-01    | null       | null       | 1700                   | null                  | 204            |
      | 2021-01-01    | null       | null       | 1699                   | null                  | 400            |
      | 2021-01-01    | null       | null       | 05-04-2021             | null                  | 400            |
      | 2021-01-01    | null       | null       | some                   | null                  | 400            |
      | 2021-01-01    | null       | null       |                        | null                  | 204            |
      | 2021-01-01    | null       | null       | null                   | null                  | 204            |
      | 2021-01-01    | null       | null       | null                   | 1700                  | 204            |
      | 2021-01-01    | null       | null       | null                   | 1699                  | 400            |
      | 2021-01-01    | null       | null       | null                   | 05-04-2021            | 400            |
      | 2021-01-01    | null       | null       | null                   | some                  | 400            |
      | 2021-01-01    | null       | null       | null                   |                       | 204            |
      | 2021-01-01    | null       | null       | null                   | null                  | 204            |

  @UpdateOrder
  Scenario Outline: Update an Order's shippingStreet field.
    Given I set the pathParams and updated body with the requisite key "accountId" for the request
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingStreet | <shippingStreet> |
    When I set the "/Order/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | shippingStreet                                                                                                                                                                                                                                                                                                                                                                                                         | effectiveDate | status | expectedStatus |
      | anystreet                                                                                                                                                                                                                                                                                                                                                                                                              | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                                                                                                                                                                                                                                                                                                                                                                    | 2022-01-01    | draft  | 201            |
      |                                                                                                                                                                                                                                                                                                                                                                                                                        | 2022-01-01    | draft  | 201            |
      | null                                                                                                                                                                                                                                                                                                                                                                                                                   | 2022-01-01    | draft  | 201            |
      | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjkl12345  | 2022-01-01    | draft  | 201            |
      | 256charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjkl123456 | 2022-01-01    | draft  | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's shippingCity field.
    Given I set the pathParams and updated body with the requisite key "accountId" for the request
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingCity | <shippingCity> |
    When I set the "/Order/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | shippingCity                              | effectiveDate | status | expectedStatus |
      | anyCity                                   | 2022-01-01    | draft  | 204            |
      | !@#$%^&*()_+~}{"?><                       | 2022-01-01    | draft  | 204            |
      |                                           | 2022-01-01    | draft  | 204            |
      | null                                      | 2022-01-01    | draft  | 204            |
      | 40chartextasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 204            |
      | 41chartextasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's shippingState field.
    Given I set the pathParams and updated body with the requisite key "accountId" for the request
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingState | <shippingState> |
    When I set the "/Order/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | shippingState                                                                     | effectiveDate | status | expectedStatus |
      | anyState                                                                          | 2022-01-01    | draft  | 204            |
      | !@#$%^&*()_+~}{"?><                                                               | 2022-01-01    | draft  | 204            |
      |                                                                                   | 2022-01-01    | draft  | 204            |
      | null                                                                              | 2022-01-01    | draft  | 204            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 204            |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's shippingPostalCode field.
    Given I set the pathParams and updated body with the requisite key "accountId" for the request
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingPostalCode | <shippingPostalCode> |
    When I set the "/Order/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | shippingPostalCode    | effectiveDate | status | expectedStatus |
      | anyPostalCode         | 2022-01-01    | draft  | 204            |
      | !@#$%^&*()_+~}{"?><   | 2022-01-01    | draft  | 204            |
      |                       | 2022-01-01    | draft  | 204            |
      | null                  | 2022-01-01    | draft  | 204            |
      | 20chartextasdfghjklm  | 2022-01-01    | draft  | 204            |
      | 21chartextasdfghjklma | 2022-01-01    | draft  | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's shippingCountry field.
    Given I set the pathParams and updated body with the requisite key "accountId" for the request
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingCountry | <shippingCountry> |
    When I set the "/Order/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | shippingCountry                                                                   | effectiveDate | status | expectedStatus |
      | anyPostalCode                                                                     | 2022-01-01    | draft  | 204            |
      | !@#$%^&*()_+~}{"?><                                                               | 2022-01-01    | draft  | 204            |
      |                                                                                   | 2022-01-01    | draft  | 204            |
      | null                                                                              | 2022-01-01    | draft  | 204            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 204            |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |