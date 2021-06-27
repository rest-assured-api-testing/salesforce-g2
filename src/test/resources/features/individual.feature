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
      |                    | Perales            |                      |                     | 201    |
      |                    | Perez              |                      | 0000-01-01          | 400    |
      |                    | Gonsalves          |                      | 02-26-2001          | 400    |
      |                    | Suarez             |                      | 2000-13-01          | 400    |
      |                    | Salazar            |                      | 2000-12-50          | 400    |
      |                    | null               |                      |                     | 400    |
      |                    |                    |                      |                     | 400    |

  @CreateIndividual
  Scenario Outline: Create a Individual
    Given I build the pathParams and body to request
      | firstName  | <firsNameIndividual>   |
      | Salutation | <salutationIndividual> |
      | BirthDate  | <birthdateIndividual> |
    When I add this "/Individual" endpoint and send the request with body
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | salutationIndividual | birthdateIndividual | status |
      | Pepito             | Mr.                  | 1988-06-09          | 400    |
      |                    | Mister               | 1985-07-09          | 400    |
      |                    |                      | 1990-05-10          | 400    |

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
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | lastNameIndividual | status |
      | Pedro Luis         | Ramirez            | 204    |
      |                    | Rodriguez          | 204    |
      | Marisol            |                    | 400    |

  @UpdateIndividual
  Scenario Outline: Update a Individual
    Given I build the pathParams and updated body to request
      | firstName  | <firsNameIndividual>   |
      | Salutation | <salutationIndividual> |
      | BirthDate  | <birthdateIndividual> |
    When I add this "/Individual/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | salutationIndividual | birthdateIndividual | status |
      | Ramiro             | Mr.                  | 1988-06-09          | 204    |
      |                    | Mister               | 1985-07-09          | 204    |
      |                    |                      | 1990-05-10          | 204    |
      |                    |                      | 1990-03-20          | 204    |
      |                    |                      |                     | 204    |
      | Person 2           |                      | 0000-12-14          | 400    |
      | Person 3           |                      | 21-08-2000          | 400    |
      | Person 4           |                      | 2000-13-21          | 400    |
      | Person 5           |                      | 2000-12-40          | 400    |

  @DeleteIndividual
  Scenario: Delete a Individual
    Given I build the pathParams to request
    When I add this "/Individual/{id}" endpoint and send the delete request
    Then the response status code should be "204"