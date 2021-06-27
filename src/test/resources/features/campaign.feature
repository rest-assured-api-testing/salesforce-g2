Feature: Requests for Campaign endpoint

  @GetCampaigns
  Scenario: Get all Campaigns
    Given
    When I add this "/Campaign" endpoint and send the request
    Then the response status code should be "200"

  @CreateCampaign
  Scenario Outline: Create a Campaign
    Given I build the pathParams and body to request
      | name  | <nameProduct> |
    When I add this "/Campaign" endpoint and send the request with body
    Then the response status code should be "201"
    Examples:
      | nameProduct          |
      | New incoming campaign |

  @GetCampaign
  Scenario: Get a Campaign
    Given I build the pathParams to request
    When I add this "/Campaign/{id}" endpoint and send the request
    Then the response status code should be "200"

  @UpdateCampaign
  Scenario Outline: Update a Product
    Given I build the pathParams and updated body to request
      | name  | <nameProduct> |
    When I add this "/Campaign/{id}" endpoint and send the request with updated body
    Then the response status code should be "204"
    Examples:
      | nameProduct         |
      | New name of the campaign |

  @DeleteCampaign
  Scenario: Delete a Campaign
    Given I build the pathParams to request
    When I add this "/Campaign/{id}" endpoint and send the delete request
    Then the response status code should be "204"