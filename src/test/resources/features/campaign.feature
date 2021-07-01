Feature: Campaign

  @GetCampaigns
  Scenario: Get all Campaigns
    Given I set a "GET" request
    When I send the request with the "/Campaign" endpoint
    Then the response status code should be "200"

  @CreateCampaign
  Scenario Outline: Create a Campaign
    Given I set a "POST" request with payload
      | name     | <nameCampaign>     |
      | isActive | <isActiveCampaign> |
      | type     | <typeCampaign>     |
      | status   | <statusCampaign>   |
    When I send the request with the "/Campaign" endpoint
    Then the response status code should be "<status>"
    And its schema should match the "success" schema
    Examples:
      | nameCampaign          | isActiveCampaign | typeCampaign            | statusCampaign | status |
      | New incoming campaign | true             | This is a test campaign | NIP1           | 201    |
      | Incoming campaign     | false            | It's a test campaign    | CAMP           | 201    |
      | New campaign          | false            | Campaign                |                | 201    |
      | campaign              | true             |                         | camp2          | 201    |
      | 0000                  | true             |                         |                | 201    |
      | .                     | true             | Solar Campaign          |                | 201    |

  @GetCampaign
  Scenario: Get a Campaign
    Given I set a "GET" request
    And I set the ID path parameter
    When I send the request with the "/Campaign/{id}" endpoint
    Then the response status code should be "200"
    And its schema should match the "campaign" schema

  @UpdateCampaign
  Scenario Outline: Update a Product
    Given I set a "PATCH" request with payload
      | name     | <nameCampaign>     |
      | isActive | <isActiveCampaign> |
      | type     | <typeCampaign>     |
      | status   | <statusCampaign>   |
    And I set the ID path parameter
    When I send the request with the "/Campaign/{id}" endpoint
    Then the response status code should be "<status>"
    Examples:
      | nameCampaign      | isActiveCampaign | typeCampaign            | statusCampaign | status |
      | NIP1              | false            | This is a test campaign | NIP1           | 204    |
      | Incoming campaign | false            | It's a test campaign    | CAMP           | 204    |
      | .                 | true             | Campaign                |                | 204    |
      | campaign          | true             |                         | ---            | 204    |
      | 0000              | false            | New Campaign            |                | 204    |
      | New campaign      | true             | .                       | .              | 204    |

  @DeleteCampaign
  Scenario: Delete a Campaign
    Given I set a "DELETE" request
    And I set the ID path parameter
    When I send the request with the "/Campaign/{id}" endpoint
    Then the response status code should be "204"