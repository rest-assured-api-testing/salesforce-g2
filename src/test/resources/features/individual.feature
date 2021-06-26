Feature: Requests for Account endpoint
  @GetIndividuals
  Scenario: Get all Individuals
    Given
    When I add this "/Individual" endpoint and send the request
    Then the response status code should be "200"

  @CreateIndividual
  Scenario Outline: Create a Individual
    Given I build the pathParams and body to request
      | firstName  | <firsNameIndividual> |
      | lastName   | <lastNameIndividual> |
    When I add this "/Individual" endpoint and send the request with body
    Then the response status code should be "201"
    Examples:
      | firsNameIndividual | lastNameIndividual |
      | Pepito             | Ramirez            |

  @GetIndividual
  Scenario: Get a Individual
    Given I build the pathParams to request
    When I add this "/Individual/{id}" endpoint and send the request
    Then the response status code should be "200"

  @UpdateIndividual
  Scenario Outline: Update a Individual
    Given I build the pathParams and updated body to request
      | firstName  | <firsNameIndividual> |
      | lastName   | <lastNameIndividual> |
    When I add this "/Individual/{id}" endpoint and send the request with updated body
    Then the response status code should be "204"
    Examples:
      | firsNameIndividual | lastNameIndividual |
      | Pedro Luis         | Ramirez            |

  @DeleteIndividual
  Scenario: Delete a Individual
    Given I build the pathParams to request
    When I add this "/Individual/{id}" endpoint and send the delete request
    Then the response status code should be "204"