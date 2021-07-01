Feature: Order

  @CreateOrder
  Scenario Outline: Create an Order with name, effectiveDate and status valid fields
    Given I set a "POST" request with payload
      | name          | <name>          |
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | name                                                                             | effectiveDate | status | expectedStatus |
      | order                                                                            | 2022-01-01    | draft  | 201            |
      | 01234567890order                                                                 | 2022-01-01    | draft  | 201            |
      |                                                                                  | 2022-01-01    | draft  | 201            |
      | null                                                                             | 2022-01-01    | draft  | 201            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 2022-01-01    | draft  | 201            |
      | order                                                                            | 2021-08-06    | draft  | 201            |
      | order                                                                            | 2021-88-06    | draft  | 201            |
      | order                                                                            | 2021-08-99    | draft  | 201            |
      | order                                                                            | 2021-00-01    | draft  | 201            |
      | order                                                                            | 2021-01-00    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with name, effectiveDate and status invalid fields
    Given I set a "POST" request with payload
      | name          | <name>          |
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | name                                                                              | effectiveDate | status | expectedStatus |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |
      | order                                                                             | 05-04-2021    | draft  | 400            |
      | order                                                                             | someDate      | draft  | 400            |
      | order                                                                             |               | draft  | 400            |
      | order                                                                             | null          | draft  | 400            |
      | order                                                                             | 2022-01-01    | other  | 400            |
      | order                                                                             | 2022-01-01    | 1      | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with description valid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | description   | <description>   |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | description                                                                                                                                                                                                                                                      | effectiveDate | status | expectedStatus |
      | description                                                                                                                                                                                                                                                      | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                                                                                                                                                                                                              | 2022-01-01    | draft  | 201            |
      |                                                                                                                                                                                                                                                                  | 2022-01-01    | draft  | 201            |
      | null                                                                                                                                                                                                                                                             | 2022-01-01    | draft  | 201            |
      | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongname  | 2022-01-01    | draft  | 201            |
      | 256charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnamea | 2022-01-01    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with billingStreet valid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingStreet | <billingStreet> |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | billingStreet                                                                                                                                                                                                                                                   | effectiveDate | status | expectedStatus |
      | anystreet                                                                                                                                                                                                                                                       | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                                                                                                                                                                                                             | 2022-01-01    | draft  | 201            |
      |                                                                                                                                                                                                                                                                 | 2022-01-01    | draft  | 201            |
      | null                                                                                                                                                                                                                                                            | 2022-01-01    | draft  | 201            |
      | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongname | 2022-01-01    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with billingStreet invalid value
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingStreet | <billingStreet> |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingStreet                                                                                                                                                                                                                                                    | effectiveDate | status | expectedStatus |
      | 256charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnamea | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingCity valid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingCity   | <billingCity>   |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | billingCity                              | effectiveDate | status | expectedStatus |
      | anyCity                                  | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                      | 2022-01-01    | draft  | 201            |
      |                                          | 2022-01-01    | draft  | 201            |
      | 40chartextasdfghjklmasdfghjklmasdfghjklm | 2022-01-01    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with billingCity invalid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingCity   | <billingCity>   |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingCity                               | effectiveDate | status | expectedStatus |
      | 41chartextasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingState valid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingState  | <billingState>  |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | billingState                                                                     | effectiveDate | status | expectedStatus |
      | anyState                                                                         | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                              | 2022-01-01    | draft  | 201            |
      |                                                                                  | 2022-01-01    | draft  | 201            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 2022-01-01    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with billingState invalid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | billingState  | <billingState>  |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingState                                                                      | effectiveDate | status | expectedStatus |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with billingPostalCode valid values
    Given I set a "POST" request with payload
      | effectiveDate     | <effectiveDate>     |
      | status            | <status>            |
      | billingPostalCode | <billingPostalCode> |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | billingPostalCode    | effectiveDate | status | expectedStatus |
      | anyPostalCode        | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><  | 2022-01-01    | draft  | 201            |
      |                      | 2022-01-01    | draft  | 201            |
      | 20chartextasdfghjklm | 2022-01-01    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with billingPostalCode invalid values
    Given I set a "POST" request with payload
      | effectiveDate     | <effectiveDate>     |
      | status            | <status>            |
      | billingPostalCode | <billingPostalCode> |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingPostalCode     | effectiveDate | status | expectedStatus |
      | 21chartextasdfghjklma | 2022-01-01    | draft  | 400            |


  @CreateOrder
  Scenario Outline: Create an Order with billingCountry valid values
    Given I set a "POST" request with payload
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | billingCountry | <billingCountry> |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | billingCountry                                                                   | effectiveDate | status | expectedStatus |
      | anyPostalCode                                                                    | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                              | 2022-01-01    | draft  | 201            |
      |                                                                                  | 2022-01-01    | draft  | 201            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 2022-01-01    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with billingCountry invalid values
    Given I set a "POST" request with payload
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | billingCountry | <billingCountry> |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | billingCountry                                                                    | effectiveDate | status | expectedStatus |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @CreateOrder
  Scenario Outline: Create an Order with poNumber valid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | poNumber      | <poNumber>      |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | poNumber                                                                         | effectiveDate | status | expectedStatus |
      | anyPoNumber                                                                      | 2022-01-01    | draft  | 201            |
      | !@#$%^&*()_+~}{"?><                                                              | 2022-01-01    | draft  | 201            |
      |                                                                                  | 2022-01-01    | draft  | 201            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 2022-01-01    | draft  | 201            |

  @CreateOrder
  Scenario Outline: Create an Order with poNumber invalid values
    Given I set a "POST" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | poNumber      | <poNumber>      |
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | poNumber                                                                          | effectiveDate | status | expectedStatus |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's name, effectiveDate and status valid values.
    Given I set a "PATCH" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | name          | <name>          |
    And I set the ID path parameter
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | name                                                                              | effectiveDate | status | expectedStatus |
      | order                                                                             | 2022-01-01    | draft  | 204            |
      | 01234567890order                                                                  | 2022-01-01    | draft  | 204            |
      |                                                                                   | 2022-01-01    | draft  | 204            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 204            |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |
      | order                                                                             | 2021-08-06    | draft  | 204            |
      | order                                                                             | 2021-88-06    | draft  | 204            |
      | order                                                                             | 2021-08-99    | draft  | 204            |
      | order                                                                             | 2021-00-01    | draft  | 204            |
      | order                                                                             | 2021-01-00    | draft  | 204            |
      | order                                                                             | 05-04-2021    | draft  | 400            |
      | order                                                                             | someDate      | draft  | 400            |
      | order                                                                             |               | draft  | 400            |
      | order                                                                             | 2022-01-01    | other  | 400            |
      | order                                                                             | 2022-01-01    | 1      | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's date fields.
    Given I set a "PATCH" request with payload
      | effectiveDate          | <effectiveDate>          |
      | endDate                | <endDate>                |
      | poDate                 | <poDate>                 |
      | customerAuthorizedDate | <customerAuthorizedDate> |
      | companyAuthorizedDate  | <companyAuthorizedDate>  |
    And I set the ID path parameter
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | effectiveDate | endDate    | poDate     | customerAuthorizedDate | companyAuthorizedDate | expectedStatus |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 204            |
      | 1700-01-01    | 2022-02-02 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 204            |
      | 1699-12-30    | 2022-02-02 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      | 05-04-2021    | 2022-02-02 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      | someDate      | 2022-02-02 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      |               | 2022-02-02 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      | 2022-01-01    | 2022-01-01 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 204            |
      | 2021-01-01    | 2020-01-01 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      | 1700-01-01    | 1700-01-01 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 204            |
      | 1699-12-30    | 1699-12-30 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      | 2021-01-01    | 05-04-2021 | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      | 2021-01-01    | someDate   | 2022-02-02 | 2022-02-02             | 2022-02-02            | 400            |
      | 2021-01-01    |            | 2022-02-02 | 2022-02-02             | 2022-02-02            | 204            |
      | 2021-01-01    | 2022-02-02 | 1700-01-01 | 2022-02-02             | 2022-02-02            | 204            |
      | 2021-01-01    | 2022-02-02 | 1699-12-30 | 2022-02-02             | 2022-02-02            | 400            |
      | 2021-01-01    | 2022-02-02 | 05-04-2021 | 2022-02-02             | 2022-02-02            | 400            |
      | 2021-01-01    | 2022-02-02 | some       | 2022-02-02             | 2022-02-02            | 400            |
      | 2021-01-01    | 2022-02-02 |            | 2022-02-02             | 2022-02-02            | 204            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 1700-01-01             | 2022-02-02            | 204            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 1699-12-30             | 2022-02-02            | 400            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 05-04-2021             | 2022-02-02            | 400            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | some                   | 2022-02-02            | 400            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 |                        | 2022-02-02            | 204            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 2022-02-02             | 1700-01-01            | 204            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 2022-02-02             | 1699-12-30            | 400            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 2022-02-02             | 05-04-2021            | 400            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 2022-02-02             | some                  | 400            |
      | 2021-01-01    | 2022-02-02 | 2022-02-02 | 2022-02-02             |                       | 204            |

  @UpdateOrder
  Scenario Outline: Update an Order's shippingStreet field.
    Given I set a "PATCH" request with payload
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingStreet | <shippingStreet> |
    And I set the ID path parameter
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | shippingStreet                                                                                                                                                                                                                                                   | effectiveDate | status | expectedStatus |
      | anystreet                                                                                                                                                                                                                                                        | 2022-01-01    | draft  | 204            |
      | !@#$%^&*()_+~}{"?><                                                                                                                                                                                                                                              | 2022-01-01    | draft  | 204            |
      |                                                                                                                                                                                                                                                                  | 2022-01-01    | draft  | 204            |
      | null                                                                                                                                                                                                                                                             | 2022-01-01    | draft  | 204            |
      | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongname  | 2022-01-01    | draft  | 204            |
      | 256charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnamea | 2022-01-01    | draft  | 400            |

  @UpdateOrder
  Scenario Outline: Update an Order's shippingCity field.
    Given I set a "PATCH" request with payload
      | effectiveDate | <effectiveDate> |
      | status        | <status>        |
      | shippingCity  | <shippingCity>  |
    And I set the ID path parameter
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order/{id}" endpoint
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
    Given I set a "PATCH" request with payload
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingState | <shippingState> |
    And I set the ID path parameter
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order/{id}" endpoint
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
    Given I set a "PATCH" request with payload
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingPostalCode | <shippingPostalCode> |
    And I set the ID path parameter
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order/{id}" endpoint
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
    Given I set a "PATCH" request with payload
      | effectiveDate  | <effectiveDate>  |
      | status         | <status>         |
      | shippingCountry | <shippingCountry> |
    And I set the ID path parameter
    And I add the required "AccountId" field to the payload
    When I send the request with the "/Order/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | shippingCountry                                                                   | effectiveDate | status | expectedStatus |
      | anyPostalCode                                                                     | 2022-01-01    | draft  | 204            |
      | !@#$%^&*()_+~}{"?><                                                               | 2022-01-01    | draft  | 204            |
      |                                                                                   | 2022-01-01    | draft  | 204            |
      | null                                                                              | 2022-01-01    | draft  | 204            |
      | 80chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 204            |
      | 81chartextasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |