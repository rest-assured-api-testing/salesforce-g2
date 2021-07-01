Feature: Individual
  @GetIndividuals
  Scenario: Get all Individuals
    Given I set a "GET" request
    When I send the request with the "/Individual" endpoint
    Then the response status code should be "200"

  @CreateIndividual
  Scenario Outline: Create an Individual with firstname, lastname, salutation and birthday
    Given I set a "POST" request with payload
      | firstName  | <firsNameIndividual>   |
      | lastName   | <lastNameIndividual>   |
      | Salutation | <salutationIndividual> |
      | BirthDate  | <birthdateIndividual> |
    When I send the request with the "/Individual" endpoint
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | lastNameIndividual | salutationIndividual | birthdateIndividual | status |
      | Pepito             | Ramirez            | Mr.                  | 1988-06-09          | 201    |
      | Rodrigo            | Caceres            | Dr.                  | 1985-07-09          | 201    |
      | Marta              | Cespedes           | Ms.                  | 1990-05-10          | 201    |
      | Maria              | Manzalba           |                      | 1990-03-20          | 201    |
      |                    | Aranjuez           |                      | 1990-04-23          | 201    |
      |                    | Perales            |                      |                     | 201    |
      |                    | Perales            |                      |                     | 201    |
      |                    | Perez              |                      | 0000-01-01          | 400    |
      |                    | Gonsalves          |                      | 02-26-2001          | 400    |
      |                    | Suarez             |                      | 2000-13-01          | 201    |
      |                    | Salazar            |                      | 2000-12-50          | 201    |
      |                    | null               |                      |                     | 201    |
      |                    |                    |                      |                     | 400    |
      | Erika              | Ramirez            | Professor            | 1985-06-09          | 201    |
      | Pool               | Caceres            | Sir                  | 1986-07-25          | 201    |
      | Santiago           | Cespedes           | Master               | 1997-05-03          | 201    |

  @CreateIndividual
  Scenario Outline: An Individual with firstname, salutation and birthday shouldn't be created without lastname
    Given I set a "POST" request with payload
      | firstName  | <firsNameIndividual>   |
      | Salutation | <salutationIndividual> |
      | BirthDate  | <birthdateIndividual> |
    When I send the request with the "/Individual" endpoint
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | salutationIndividual | birthdateIndividual | status |
      | Pepito             | Mr.                  | 1988-06-09          | 400    |
      |                    | Mister               | 1985-07-09          | 400    |
      |                    |                      | 1990-05-10          | 400    |

  @GetIndividual
  Scenario: Get an Individual
    Given I set a "GET" request
    And I set the ID path parameter
    When I send the request with the "/Individual/{id}" endpoint
    Then the response status code should be "200"
    And its schema should match the "individual" schema

  @UpdateIndividual
  Scenario Outline: Update firstname and lastname of an Individual
    Given I set a "PATCH" request with payload
      | firstName  | <firsNameIndividual> |
      | lastName   | <lastNameIndividual> |
    And I set the ID path parameter
    When I send the request with the "/Individual/{id}" endpoint
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | lastNameIndividual | status |
      | Pedro Luis         | Ramirez            | 204    |
      |                    | Rodriguez          | 204    |

  @UpdateIndividual
  Scenario Outline: Firstname shouldn't be updated with null lastname of an Individual
    Given I set a "PATCH" request with payload
      | firstName  | <firsNameIndividual> |
      | lastName   | <lastNameIndividual> |
    And I set the ID path parameter
    When I send the request with the "/Individual/{id}" endpoint
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | lastNameIndividual | status |
      | Marisol            |                    | 400    |

  @UpdateIndividual
  Scenario Outline: Update firstname, salutation and birthday of an Individual
    Given I set a "PATCH" request with payload
      | firstName  | <firsNameIndividual>   |
      | Salutation | <salutationIndividual> |
      | BirthDate  | <birthdateIndividual> |
    And I set the ID path parameter
    When I send the request with the "/Individual/{id}" endpoint
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | salutationIndividual | birthdateIndividual | status |
      | Ramiro             | Mr.                  | 1988-06-09          | 204    |
      |                    | Mister               | 1985-07-09          | 204    |
      |                    |                      | 1990-05-10          | 204    |
      |                    |                      | 1990-03-20          | 204    |
      |                    |                      |                     | 204    |
      | Person 4           |                      | 2000-13-21          | 204    |
      | Person 5           |                      | 2000-12-40          | 204    |

  @UpdateIndividual
  Scenario Outline: Firstname, salutation shouldn't be updated with a bad birthday format of an Individual
    Given I set a "PATCH" request with payload
      | firstName  | <firsNameIndividual>   |
      | Salutation | <salutationIndividual> |
      | BirthDate  | <birthdateIndividual>  |
    And I set the ID path parameter
    When I send the request with the "/Individual/{id}" endpoint
    Then the response status code should be "<status>"
    Examples:
      | firsNameIndividual | salutationIndividual | birthdateIndividual | status |
      | Person 2           |                      | 0000-12-14          | 400    |
      | Person 3           |                      | 21-08-2000          | 400    |

  @DeleteIndividual
  Scenario: Delete an Individual
    Given I set a "DELETE" request
    And I set the ID path parameter
    When I send the request with the "/Individual/{id}" endpoint
    Then the response status code should be "204"
