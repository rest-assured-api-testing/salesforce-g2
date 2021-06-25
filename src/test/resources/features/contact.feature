Feature: Contact endpoint tests
  description

  @CreateContact
  Scenario Outline: Create contact with firstname and lastname values
    Given I create a body payload
    And I set the firstname value to "<firstname>"
    And I set the lastname value to "<lastname>"
    When I execute a "POST" request with the "/contact" contact endpoint
    Then The response status code should be <expectedStatus>

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
    Given I create a body payload
    And I set the firstname value to "<firstname>"
    And I set the lastname value to "<lastname>"
    And I set the birthdate value to "<birthdate>"
    When I execute a "POST" request with the "/contact" endpoint
    Then The response status code should be <expectedStatus>

    Examples:
      | firstname | lastname | birthdate  | expectedStatus |
      | firstname | lastname | 1999-01-01 | 201            |
      | firstname | lastname | null       | 201            |
      | firstname | lastname | anytext    | 400            |
      | firstname | lastname | 1999-33-01 | 400            |
      | firstname | lastname | 1999-01-33 | 400            |
      | firstname | lastname |            | 400            |

  @CreateContact
  Scenario Outline: Create contact with firstname, lastname and department values
    Given I create a body payload
    And I set the firstname value to "<firstname>"
    And I set the lastname value to "<lastname>"
    And I set the department value to "<department>"
    When I execute a "POST" request with the "/contact" contact endpoint
    Then The response status code should be <expectedStatus>

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
    Given I create a body payload
    And I set the firstname value to "<firstname>"
    And I set the lastname value to "<lastname>"
    And I set the department value to "<phone>"
    When I execute a "POST" request with the "/contact" endpoint
    Then The response status code should be <expectedStatus>

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