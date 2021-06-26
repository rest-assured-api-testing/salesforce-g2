Feature: Requests for Account endpoint
  @GetIndividuals
  Scenario: Get all Individuals
    Given
    When I add this "/Individual" endpoint and send the request
    Then the response status code should be "200"

  @CreateIndividual
  Scenario Outline: Create a Individual
    Given I build the pathParams and body to request
      | firstName  | <firsNameIndividual>   |
      | lastName   | <lastNameIndividual>   |
      | Salutation | <salutationIndividual> |
      | BirthDate  | <birthdateIndividual> |
    When I add this "/Individual" endpoint and send the request with body
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | lastNameIndividual | salutationIndividual | birthdateIndividual | status |
      | Pepito             | Ramirez            | Mr.                  | 1988-06-09          | 201    |
      | Rodrigo            | Caceres            | Mister               | 1985-07-09          | 201    |
      | Marta              | Cespedes           | Miss                 | 1990-05-10          | 201    |
      | Maria              | Manzalba           |                      | 1990-03-20          | 201    |
      |                    | Aranjuez           |                      | 1990-04-23          | 201    |
      |                    | Perales            |                      |                     | 201    |

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