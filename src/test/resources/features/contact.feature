Feature: Contact endpoint tests
  description

  @CreateContact
  Scenario Outline: Create a Contact
    Given I create a body payload
    And I set the firstname value to "<firstname>"
    And I set the lastname value to "<lastname>"
    And I set the birthdate value to "<birthdate>"
    And I set the department value to "<department>"
    And I set the description value to "<description>"
    And I set the email value to "<email>"
    And I set the phone value to "<phone>"
    When I execute a "POST" request with the "/contact" endpoint
    Then The response status code should be <expectedStatus>

    Examples:
      | firstname | lastname | birthdate  | department | description | email          | phone   | expectedStatus |
      | name      | lastname | 1999-01-12 | finances   | testing     | email@mail.com | 7980911 | 201            |