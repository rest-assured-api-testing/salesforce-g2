Feature: Contact endpoint tests
  description

  @CreateContact
  Scenario Outline: Create contact with firstname and lastname values
    Given I build the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    When I add this "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname                                           | lastname                                            | expectedStatus |
      | firstname                                           | lastname                                            | 201            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | lastname                                            | 201            |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | lastname                                            | 400            |
      |                                                     | lastname                                            | 400            |
      | 1234                                                | lastname                                            | 400            |
      | firstname                                           |                                                     | 400            |
      | firstname                                           | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 201            |
      | firstname                                           | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname                                           | 1234                                                | 400            |
      | firstname                                           | !#$%%                                               | 400            |


  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and birthdate values
    Given I build the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    When I add this "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | 1999-01-01 | 201            |
      | firstname | lastname | null       | 201            |
      | firstname | lastname | anytext    | 400            |
      | firstname | lastname | 1999-33-01 | 400            |
      | firstname | lastname | 1999-01-33 | 400            |
      | firstname | lastname |            | 400            |
      | firstname | lastname | 0001-01-01 | 400            |
      | firstname | lastname | 1900-01-01 | 400            |

  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and department values
    Given I build the pathParams and body to request
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    When I add this "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | department                                          | expectedStatus |
      | firstname | lastname | finance                                             | 201            |
      | firstname | lastname | null                                                | 201            |
      | firstname | lastname | 1124                                                | 201            |
      | firstname | lastname |                                                     | 400            |
      | firstname | lastname | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 201            |
      | firstname | lastname | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !^#$%^                                              | 400            |

  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and phone values
    Given I build the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    When I add this "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | phone                | expectedStatus |
      | firstname | lastname | 44444444             | 201            |
      | firstname | lastname | 123456789012345      | 201            |
      | firstname | lastname | 1234567890123456789  | 201            |
      | firstname | lastname | 12345678901234567890 | 400            |
      | firstname | lastname | null                 | 201            |
      | firstname | lastname | anytext              | 400            |
      | firstname | lastname | !^#$%^               | 400            |
      | firstname | lastname |                      | 400            |

  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and description values
    Given I build the pathParams and body to request
      | firstname   | <firstname>   |
      | lastname    | <lastname>    |
      | description | <description> |
    When I add this "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | description                                                                                                                                                                                                                                                 | expectedStatus |  |
      | firstname | lastname | description                                                                                                                                                                                                                                                 | 201            |  |
      | firstname | lastname | null                                                                                                                                                                                                                                                        | 201            |  |
      | firstname | lastname |                                                                                                                                                                                                                                                             | 400            |  |
      | firstname | lastname | 250chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 201            |  |
      | firstname | lastname | 251chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |  |


  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and email values
    Given I build the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    When I add this "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | email                                               | expectedStatus |
      | firstname | lastname | email@mail.com                                      | 201            |
      | firstname | lastname |                                                     | 400            |
      | firstname | lastname | null                                                | 201            |
      | firstname | lastname | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 201            |
      | firstname | lastname | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !@#$%^&*()}{"                                       | 400            |

  @DeleteContact
  Scenario: Delete a Contact
    Given I build the pathParams to request
    When I add this "/Contact/{id}" endpoint and send the delete request
    Then the response status code should be "204"

  @UpdateContact
  Scenario Outline: Update a Contact firstname and lastname
    Given I build the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    When I add this "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname                                           | lastname                                            | expectedStatus |
      | firstnameUpdated                                    | lastnameUpdated                                     | 204            |
      | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | lastname                                            | 204            |
      | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | lastname                                            | 400            |
      |                                                     | lastname                                            | 400            |
      | 1234                                                | lastname                                            | 400            |
      | firstname                                           |                                                     | 400            |
      | firstname                                           | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 204            |
      | firstname                                           | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname                                           | 1234                                                | 400            |
      | firstname                                           | !#$%%                                               | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact birthday value
    Given I build the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    When I add this "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | 1999-01-01 | 204            |
      | firstname | lastname | null       | 204            |
      | firstname | lastname | anytext    | 400            |
      | firstname | lastname | 1999-33-01 | 400            |
      | firstname | lastname | 1999-01-33 | 400            |
      | firstname | lastname |            | 400            |
      | firstname | lastname | 0001-01-01 | 400            |
      | firstname | lastname | 1900-01-01 | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact department value
    Given I build the pathParams and updated body to request
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    When I add this "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
        Examples:
          | firstname | lastname | department                                          | expectedStatus |
          | firstname | lastname | finance                                             | 204            |
          | firstname | lastname | null                                                | 204            |
          | firstname | lastname | 1124                                                | 204            |
          | firstname | lastname |                                                     | 400            |
          | firstname | lastname | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 204            |
          | firstname | lastname | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
          | firstname | lastname | !^#$%^                                              | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact phone value
    Given I build the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    When I add this "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | phone                | expectedStatus |
      | firstname | lastname | 44444444             | 204            |
      | firstname | lastname | 123456789012345      | 204            |
      | firstname | lastname | 1234567890123456789  | 204            |
      | firstname | lastname | 12345678901234567890 | 400            |
      | firstname | lastname | null                 | 204            |
      | firstname | lastname | anytext              | 400            |
      | firstname | lastname | !^#$%^               | 400            |
      | firstname | lastname |                      | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact description value
    Given I build the pathParams and updated body to request
      | firstname   | <firstname>   |
      | lastname    | <lastname>    |
      | description | <description> |
    When I add this "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | description                                                                                                                                                                                                                                                 | expectedStatus |  |
      | firstname | lastname | description                                                                                                                                                                                                                                                 | 204            |  |
      | firstname | lastname | null                                                                                                                                                                                                                                                        | 204            |  |
      | firstname | lastname |                                                                                                                                                                                                                                                             | 400            |  |
      | firstname | lastname | 250chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 204            |  |
      | firstname | lastname | 251chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |  |

  @UpdateContact
  Scenario Outline: Update a Contact email value
    Given I build the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    When I add this "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | email                                               | expectedStatus |
      | firstname | lastname | email@mail.com                                      | 204            |
      | firstname | lastname |                                                     | 400            |
      | firstname | lastname | null                                                | 204            |
      | firstname | lastname | 50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklm  | 204            |
      | firstname | lastname | 51charlongnameghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !@#$%^&*()}{"                                       | 400            |