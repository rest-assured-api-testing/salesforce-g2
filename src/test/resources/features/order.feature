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
      | name                                                | effectiveDate | status | expectedStatus |
      | order                                               | 2022-01-01    | draft  | 201            |
      | 01234567890order                                    | 2022-01-01    | draft  | 201            |
      |                                                     | 2022-01-01    | draft  | 400            |
      | null                                                | 2022-01-01    | draft  | 400            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 2022-01-01    | draft  | 201            |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 2022-01-01    | draft  | 400            |
      | order                                               | 2021-08-06    | draft  | 201            |
      | order                                               | 2021-33-06    | draft  | 400            |
      | order                                               | 2021-08-33    | draft  | 400            |
      | order                                               | 2021-00-01    | draft  | 400            |
      | order                                               | 2021-01-00    | draft  | 400            |
      | order                                               | 05-04-2021    | draft  | 400            |
      | order                                               | someDate      | draft  | 400            |
      | order                                               |               | draft  | 400            |
      | order                                               | null          | draft  | 400            |
      | order                                               | 2022-01-01    | other  | 400            |
      | order                                               | 2022-01-01    | 1      | 400            |