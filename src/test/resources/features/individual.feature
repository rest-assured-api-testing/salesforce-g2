Feature: Requests for Individual endpoint
  @GetIndividuals
  Scenario: Get all Individuals
    Given I build a all get request "GET"
    When I add this "/Individual" endpoint and execute all get request
    Then the response status code should be "200" to all get request

  @CreateIndividual
  Scenario: Create a Individual
    Given I build a post request "POST"
    When I add this "/Individual" endpoint and execute post request
    Then the response status code should be "201" to post request

  @GetIndividual
  Scenario: Get a Individual
    Given I build a get request "GET"
    When I add this "/Individual/{id}" endpoint and execute get request
    Then the response status code should be "200" to get request

  @UpdateIndividual
  Scenario: Update a Individual
    Given I build a update request "PATCH"
    When I add this "/Individual/{id}" endpoint and execute patch request
    Then the response status code should be "204" to patch request

  @DeleteIndividual
  Scenario: Delete a Individual
    Given I build a delete request "DELETE"
    When I add this "/Individual/{id}" endpoint and execute delete request
    Then the response status code should be "204" to delete request