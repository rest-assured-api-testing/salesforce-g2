Feature: Order endpoint tests
  description

  @CreateOrder
  Scenario Outline: Create an Order
    Given I create a body payload
      | name          | <name>          |
      | effectiveDate | <effectiveDate> |
      | status        |<status>         |
    When I add the "/order" endpoint and execute a "POST" request
    Then The response status code should be <expectedStatus>

    Examples:
      | name   | effectiveDate | status | expectedStatus |
      | test 1 | 2021-24-06    | draft  | 201            |
      | test 2 | 2021-05-24    | draft  | 400            |
      | test 3 | 05-04-2021    | draft  | 400            |