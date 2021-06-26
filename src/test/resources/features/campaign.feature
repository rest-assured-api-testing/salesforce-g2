Feature: Requests for Campaign endpoint

  @GetCampaigns
  Scenario: Get all Campaigns
    Given I build get campaigns request
    When I add this "/Campaign" endpoint and execute get campaigns request
    Then the response status code should be "200" to get campaigns request

  @CreateCampaign
  Scenario: Create a Campaign
    Given I build post campaign request
    When I add this "/Campaign" endpoint and execute post campaign request
    Then the response status code should be "201" to post campaign request

  @GetCampaign
  Scenario: Get a Campaign
    Given I build get a campaign request
    When I add this "/Campaign/{id}" endpoint and execute get a campaign request
    Then the response status code should be "200" to get a campaign request

  @UpdateCampaign
  Scenario: Update a Campaign
    Given I build update campaign request
    When I add this "/Campaign/{id}" endpoint and execute patch campaign request
    Then the response status code should be "204" to patch campaign request

  @DeleteCampaign
  Scenario: Delete a Campaign
    Given I build delete a campaign request
    When I add this "/Campaign/{id}" endpoint and execute delete a campaign request
    Then the response status code should be "204" to delete a campaign request