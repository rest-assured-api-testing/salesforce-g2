Feature: Requests for Individual endpoint
  @GetIndividuals
  Scenario: Get all Individuals
    Given
    When I add this "/Individual" endpoint and execute "GETINDIVIDUALS" request
    Then the response status code should be "200" to "THENINDIVIDUALS" request

  @CreateIndividual
  Scenario: Create a Individual
    Given I build "GIVENCREATEINDIVIDUAL" request
    When I add this "/Individual" endpoint and execute "POSTINDIVIDUAL" request
    Then the response status code should be "201" to "THENINDIVIDUALS" request

  @GetIndividual
  Scenario: Get a Individual
    Given I build "GIVENGETDELETEINDIVIDUAL" request
    When I add this "/Individual/{id}" endpoint and execute "GETINDIVIDUALS" request
    Then the response status code should be "200" to "THENINDIVIDUALS" request

  @UpdateIndividual
  Scenario: Update a Individual
    Given I build "GIVENUPDATEINDIVIDUAL" request
    When I add this "/Individual/{id}" endpoint and execute "PATCHINDIVIDUAL" request
    Then the response status code should be "204" to "THENINDIVIDUALS" request

  @DeleteIndividual
  Scenario: Delete a Individual
    Given I build "GIVENGETDELETEINDIVIDUAL" request
    When I add this "/Individual/{id}" endpoint and execute "DELETEINDIVIDUAL" request
    Then the response status code should be "204" to "THENINDIVIDUALS" request