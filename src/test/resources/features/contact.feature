Feature: Contact

  @CreateContact
  Scenario Outline: Create contact with firstname and lastname valid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | expectedStatus |
      | firstname | lastname | 201            |
      | 40charlongnameghjklmasdfghjklmasdfghjklm | lastname                                                                         | 201            |
      |                                          | lastname                                                                         | 201            |
      | null                                     | lastname                                                                         | 201            |
      | 1234                                     | lastname                                                                         | 201            |
      | firstname                                | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 201            |
      | firstname                                | 1234                                                                             | 201            |
      | firstname                                | !#$%%                                                                            | 201            |

  @CreateContact
  Scenario Outline: Create contact with firstname and lastname invalid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname                                 | lastname                                                                          | expectedStatus |
      | 41charlongnameghjklmasdfghjklmasdfghjklma | lastname                                                                          | 400            |
      | firstname                                 |                                                                                   | 400            |
      | firstname                                 | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |

  @CreateContact
  Scenario Outline: Create contact birthdate valid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | 1999-01-01 | 201            |
      | firstname | lastname | 1999-33-01 | 201            |
      | firstname | lastname | 1999-01-33 | 201            |
      | firstname | lastname |            | 201            |
      | firstname | lastname | 1700-12-30 | 201            |

  @CreateContact
  Scenario Outline: Create contact birthdate invalid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | null       | 400            |
      | firstname | lastname | anytext    | 400            |
      | firstname | lastname | 1699-01-01 | 400            |

  @CreateContact
  Scenario Outline: Create contact with department valid values
    Given I set a "POST" request with payload
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | department                                                                       | expectedStatus |
      | firstname | lastname | finance                                                                          | 201            |
      | firstname | lastname | null                                                                             | 201            |
      | firstname | lastname | 1124                                                                             | 201            |
      | firstname | lastname |                                                                                  | 201            |
      | firstname | lastname | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 201            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                                                                | 201            |

  @CreateContact
  Scenario Outline: Create contact with department invalid values
    Given I set a "POST" request with payload
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | department                                                                        | expectedStatus |
      | firstname | lastname | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |

  @CreateContact
  Scenario Outline: Create contact with phone valid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | phone                                    | expectedStatus |
      | firstname | lastname | 44444444                                 | 201            |
      | firstname | lastname | 40charlongnameghjklmasdfghjklmasdfghjklm | 201            |
      | firstname | lastname | null                                     | 201            |
      | firstname | lastname | anytext                                  | 201            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                        | 201            |
      | firstname | lastname |                                          | 201            |

  @CreateContact
  Scenario Outline: Create contact with phone invalid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | phone                                     | expectedStatus |
      | firstname | lastname | 41charlongnameghjklmasdfghjklmasdfghjklma | 400            |

  @CreateContact
  Scenario Outline: Create contact with description valid values
    Given I set a "POST" request with payload
      | firstname   | <firstname>   |
      | lastname    | <lastname>    |
      | description | <description> |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | description                                                                                                                                                                                                                                                     | expectedStatus |
      | firstname | lastname | description                                                                                                                                                                                                                                                     | 201            |
      | firstname | lastname |                                                                                                                                                                                                                                                                 | 201            |
      | firstname | lastname | 255charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongname | 201            |

  @CreateContact
  Scenario Outline: Create contact with description invalid values
    Given I set a "POST" request with payload
      | firstname   | <firstname>   |
      | lastname    | <lastname>    |
      | description | <description> |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And its schema should match the "success" schema
    Examples:
      | firstname | lastname | description                                                                                                                                                                                                                                                      | expectedStatus |
      | firstname | lastname | 256charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm50charlongnamea | 400            |

  @CreateContact
  Scenario Outline: Create contact with email valid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And Validate "responsetocreate" schema
    Examples:
      | firstname | lastname | email                                                                            | expectedStatus |
      | firstname | lastname | email@mail.com                                                                   | 201            |
      | firstname | lastname | a@b.c                                                                            | 201            |
      | firstname | lastname |                                                                                  | 201            |
      | firstname | lastname | 80charlongname@mail.comfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 201            |

  @CreateContact
  Scenario Outline: Create contact with email invalid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    When I send the request with the "/Contact" endpoint
    Then the response status code should be "<expectedStatus>"
    And Validate "responsetocreate" schema
    Examples:
      | firstname | lastname | email                                                                             | expectedStatus |
      | firstname | lastname | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                                                                 | 400            |

  @DeleteContact
  Scenario: Delete a Contact
    Given I set a "DELETE" request
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "204"

  @UpdateContact
  Scenario Outline: Update a Contact firstname and lastname valid values
    Given I set a "PATCH" request with payloadt
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname                                | lastname                                                                         | expectedStatus |
      | firstnameUpdated                         | lastnameUpdated                                                                  | 204            |
      | 40charlongnameghjklmasdfghjklmasdfghjklm | lastname                                                                         | 204            |
      |                                          | lastname                                                                         | 204            |
      | 1234                                     | lastname                                                                         | 204            |
      | firstname                                | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 204            |
      | firstname                                | 1234                                                                             | 204            |
      | firstname                                | !@#$%^&*()_+}{"?~                                                                | 204            |

  @UpdateContact
  Scenario Outline: Update a Contact firstname and lastname invalid values
    Given I set a "PATCH" request with payloadt
      | firstname | <firstname> |
      | lastname  | <lastname>  |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname                                 | lastname                                                                          | expectedStatus |
      | 41charlongnameghjklmasdfghjklmasdfghjklma | lastname                                                                          | 400            |
      | firstname                                 |                                                                                   | 400            |
      | firstname                                 | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact birthday valid values
    Given I set a "PATCH" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | 1999-01-01 | 204            |
      | firstname | lastname | 1999-33-01 | 204            |
      | firstname | lastname | 1999-01-33 | 204            |
      | firstname | lastname |            | 204            |
      | firstname | lastname | 1700-12-30 | 204            |

  @UpdateContact
  Scenario Outline: Update a Contact birthday invalid values
    Given I set a "PATCH" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | birthdate | <birthdate> |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | anytext    | 400            |
      | firstname | lastname | 0001-01-01 | 400            |
      | firstname | lastname | 1700-12-30 | 204            |
      | firstname | lastname | 1699-01-01 | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact department valid values
    Given I set a "PATCH" request with payload
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
        Examples:
          | firstname | lastname | department                                                                       | expectedStatus |
          | firstname | lastname | finance                                                                          | 204            |
          | firstname | lastname | 1124                                                                             | 204            |
          | firstname | lastname |                                                                                  | 204            |
          | firstname | lastname | 80charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 204            |
          | firstname | lastname | !@#$%^&*()_+}{"?~                                                                | 204            |

  @UpdateContact
  Scenario Outline: Update a Contact department invalid values
    Given I set a "PATCH" request with payload
      | firstname  | <firstname>  |
      | lastname   | <lastname>   |
      | department | <department> |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | department                                                                        | expectedStatus |
      | firstname | lastname | 81charlongnameghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |


  @UpdateContact
  Scenario Outline: Update a Contact phone valid values
    Given I set a "PATCH" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    And I set the ID path parameter
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | phone                                    | expectedStatus |
      | firstname | lastname | 44444444                                 | 204            |
      | firstname | lastname | 40charlongnameghjklmasdfghjklmasdfghjklm | 204            |
      | firstname | lastname | anytext                                  | 204            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                        | 204            |
      | firstname | lastname |                                          | 204            |

  @UpdateContact
  Scenario Outline: Update a Contact phone invalid values
    Given I set a "PATCH" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | phone     | <phone>     |
    And I set the ID path parameter
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | phone                                     | expectedStatus |
      | firstname | lastname | 41charlongnameghjklmasdfghjklmasdfghjklma | 400            |

  @UpdateContact
  Scenario Outline: Update a Contact description valid values
    Given I set a "POST" request with payload
      | firstname   | <firstname>   |
      | lastname    | <lastname>    |
      | description | <description> |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | description                                                                                                                                                                                                                                                      | expectedStatus |  |
      | firstname | lastname | description                                                                                                                                                                                                                                                      | 204            |  |
      | firstname | lastname | null                                                                                                                                                                                                                                                             | 204            |  |
      | firstname | lastname |                                                                                                                                                                                                                                                                  | 204            |  |
      | firstname | lastname | 255chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfg  | 204            |  |
      | firstname | lastname | 256chartextsdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfgh | 204              |  |

  @UpdateContact
  Scenario Outline: Update a Contact email valid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | email                                                                            | expectedStatus |
      | firstname | lastname | email@mail.com                                                                   | 204            |
      | firstname | lastname |                                                                                  | 204            |
      | firstname | lastname | a@b.c                                                                            | 204            |
      | firstname | lastname | 80charlongname@mail.comfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklm | 204            |
      |           |          |                                                                                  |                |

  @UpdateContact
  Scenario Outline: Update a Contact email invalid values
    Given I set a "POST" request with payload
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | email     | <email>     |
    And I set the ID path parameter
    When I send the request with the "/Contact/{id}" endpoint
    Then the response status code should be "<expectedStatus>"
    Examples:
      | firstname | lastname | email                                                                             | expectedStatus |
      | firstname | lastname | 1234567890                                                                        | 400            |
      | firstname | lastname | somemail.com                                                                      | 400            |
      | firstname | lastname | 81charlongname@mail.comfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklmasdfghjklma | 400            |
      | firstname | lastname | !@#$%^&*()_+}{"?~                                                                 | 400            |