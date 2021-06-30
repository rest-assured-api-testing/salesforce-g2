Feature: Contact

  @CreateContact
  Scenario Outline: Create contact with firstname and lastname values
    Given I set the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    When I set the "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>" with the "responsetocreate" schema

    Examples:
      | firstname                                 | lastname                                                                          | expectedStatus |
      | firstname                                 | lastname                                                                          | 201            |
      | 40charlongnameghjklmasdfghjklmasdfghjklm  | lastname                                                                          | 201            |
      | 41charlongnameghjklmasdfghjklmasdfghjklma | lastname                                                                          | 400            |
      |                                           | lastname                                                                          | 201            |
      | null                                      | lastname                                                                          | 201            |
      | 1234                                      | lastname                                                                          | 201            |
      | firstname                                 |                                                                                   | 400            |
      | firstname                                 | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 201            |
      | firstname                                 | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname                                 | 1234                                                                              | 201            |
      | firstname                                 | !#$%%                                                                             | 201            |


  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and birthdate values
    Given I set the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    When I set the "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>" with the "responsetocreate" schema

    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | 1999-01-01 | 201            |
      | firstname | lastname | null       | 400            |
      | firstname | lastname | anytext    | 400            |
      | firstname | lastname | 1999-33-01 | 201            |
      | firstname | lastname | 1999-01-33 | 201            |
      | firstname | lastname |            | 201            |
      | firstname | lastname | 1700-12-30 | 201            |
      | firstname | lastname | 1699-01-01 | 400            |


  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and department values
    Given I set the pathParams and body to request
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    When I set the "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>" with the "responsetocreate" schema

    Examples:
      | firstname | lastname | department                                                                        | expectedStatus |
      | firstname | lastname | finance                                                                           | 201            |
      | firstname | lastname | null                                                                              | 201            |
      | firstname | lastname | 1124                                                                              | 201            |
      | firstname | lastname |                                                                                   | 201              |
      | firstname | lastname | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 201            |
      | firstname | lastname | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                                                                 | 201            |

  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and phone values
    Given I set the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    When I set the "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>" with the "responsetocreate" schema

    Examples:
      | firstname | lastname | phone                                     | expectedStatus |
      | firstname | lastname | 44444444                                  | 201            |
      | firstname | lastname | 40charlongnameghjklmasdfghjklmasdfghjklm  | 201            |
      | firstname | lastname | 41charlongnameghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | null                                      | 201            |
      | firstname | lastname | anytext                                   | 201            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                         | 201            |
      | firstname | lastname |                                           | 201            |

  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and description values
    Given I set the pathParams and body to request
      | firstname   | <firstname>   |
      | lastname    | <lastname>    |
      | description | <description> |
    When I set the "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>" with the "responsetocreate" schema

    Examples:
      | firstname | lastname | description                                                                                                                                                                                                                                                      | expectedStatus |  |
      | firstname | lastname | description                                                                                                                                                                                                                                                      | 201            |  |
      | firstname | lastname |                                                                                                                                                                                                                                                                  | 201            |  |
      | firstname | lastname | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongname  | 201            |  |
      | firstname | lastname | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnamea | 201              |  |


  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and email values
    Given I set the pathParams and body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    When I set the "/Contact" endpoint and send the request with body
    Then the response status code should be "<expectedStatus>" with the "responsetocreate" schema

    Examples:
      | firstname | lastname | email                                                                             | expectedStatus |
      | firstname | lastname | email@mail.com                                                                    | 201            |
      | firstname | lastname | a@b.c                                                                             | 201            |
      | firstname | lastname |                                                                                   | 201            |
      | firstname | lastname | 80charlongname@mail.comfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 201            |
      | firstname | lastname | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                                                                 | 400            |

  @DeleteContact
  Scenario: Delete a Contact
    Given I set the pathParams to request
    When I set the "/Contact/{id}" endpoint and send the delete request
    Then the response status code should be "204"

  @UpdateContact
  Scenario Outline: Update a Contact firstname and lastname
    Given I set the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    When I set the "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname                                 | lastname                                                                          | expectedStatus |
      | firstnameUpdated                          | lastnameUpdated                                                                   | 204            |
      | 40charlongnameghjklmasdfghjklmasdfghjklm  | lastname                                                                          | 204            |
      | 41charlongnameghjklmasdfghjklmasdfghjklma | lastname                                                                          | 400            |
      |                                           | lastname                                                                          | 204            |
      | 1234                                      | lastname                                                                          | 204              |
      | firstname                                 |                                                                                   | 400            |
      | firstname                                 | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 204            |
      | firstname                                 | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname                                 | 1234                                                                              | 204            |
      | firstname                                 | !@#$%^&*()_+}{"?~                                                                 | 204            |

  @UpdateContact
  Scenario Outline: Update a Contact birthday value
    Given I set the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    When I set the "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | 1999-01-01 | 204            |
      | firstname | lastname | anytext    | 400            |
      | firstname | lastname | 1999-33-01 | 204            |
      | firstname | lastname | 1999-01-33 | 204            |
      | firstname | lastname |            | 204            |
      | firstname | lastname | 0001-01-01 | 400            |
      | firstname | lastname | 1700-12-30 | 204            |
      | firstname | lastname | 1699-01-01 | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact department value
    Given I set the pathParams and updated body to request
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    When I set the "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
        Examples:
          | firstname | lastname | department                                                                        | expectedStatus |
          | firstname | lastname | finance                                                                           | 204            |
          | firstname | lastname | 1124                                                                              | 204            |
          | firstname | lastname |                                                                                   | 204            |
          | firstname | lastname | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 204            |
          | firstname | lastname | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
          | firstname | lastname | !@#$%^&*()_+}{"?~                                                                 | 204            |

  @UpdateContact
  Scenario Outline: Update a Contact phone value
    Given I set the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    When I set the "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | phone                                     | expectedStatus |
      | firstname | lastname | 44444444                                  | 204            |
      | firstname | lastname | 40charlongnameghjklmasdfghjklmasdfghjklm  | 204            |
      | firstname | lastname | 41charlongnameghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | anytext                                   | 204            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                         | 204            |
      | firstname | lastname |                                           | 204            |

  @UpdateContact
  Scenario Outline: Update a Contact description value
    Given I set the pathParams and updated body to request
      | firstname   | <firstname>   |
      | lastname    | <lastname>    |
      | description | <description> |
    When I set the "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"

    Examples:
      | firstname | lastname | description                                                                                                                                                                                                                                                      | expectedStatus |  |
      | firstname | lastname | description                                                                                                                                                                                                                                                      | 204            |  |
      | firstname | lastname | null                                                                                                                                                                                                                                                             | 204            |  |
      | firstname | lastname |                                                                                                                                                                                                                                                                  | 204            |  |
      | firstname | lastname | 255chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfg  | 204            |  |
      | firstname | lastname | 256chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfgh | 204              |  |

  @UpdateContact
  Scenario Outline: Update a Contact email value
    Given I set the pathParams and updated body to request
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    When I set the "/Contact/{id}" endpoint and send the request with updated body
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | email                                                                             | expectedStatus |
      | firstname | lastname | email@mail.com                                                                    | 204            |
      | firstname | lastname |                                                                                   | 204            |
      | firstname | lastname | 1234567890                                                                        | 400            |
      | firstname | lastname | somemail.com                                                                      | 400            |
      | firstname | lastname | a@b.c                                                                             | 204            |
      | firstname | lastname | 80charlongname@mail.comfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm  | 204            |
      | firstname | lastname | 81charlongname@mail.comfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                                                                 | 400            |