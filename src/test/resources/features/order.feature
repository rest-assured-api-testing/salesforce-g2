Feature: Order endpoint tests
  description

  @CreateOrder
  Scenario Outline: Create an Order
    Given I create a body payload
    | Name          | "<name>"          |
    | EffectiveDate | "<effectiveDate>" |
    | Status        | "<status>"        |
    When I execute a "POST" request with the "/Order" endpoint
    Then The response status code should be <expectedStatus>

    Examples:
      | name                                                | effectiveDate | status | expectedStatus |
      | order 1                                             | 2021-08-06    | draft  | 201            |
      | order 2                                             | 2021-33-06    | draft  | 400            |
      | order 3                                             | 2021-08-33    | draft  | 400            |
      | order 4                                             | 2021-00-00    | draft  | 400            |
      | order 5                                             | 05-04-2021    | draft  | 400            |
      | order 8                                             | someDate      | draft  | 400            |
      |                                                     | 2021-11-11    | draft  | 400            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 2021-11-11    | draft  | 201            |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 2021-11-11    | draft  | 400            |
      | order 12                                            | 2021-11-11    | other  | 400            |
      | order 13                                            | 2021-11-11    | 1      | 400            |