Feature: Campaign

  @GetCampaigns
  Scenario: Get all Campaigns
  Given
    When I set the "/Campaign" endpoint and send the request
    Then the response status code should be "200"

  @CreateCampaign
  Scenario Outline: Create a Campaign
    Given I set the pathParams and body to request
      | name     | <nameCampaign>     |
      | isActive | <isActiveCampaign> |
      | type     | <typeCampaign>     |
      | status   | <statusCampaign>   |
    When I set the "/Campaign" endpoint and send the request with body
    Then the response status code should be "<status>" with the "responsetocreate" schema
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
    Given I set the pathParams to request
    When I set the "/Campaign/{id}" endpoint and send the request
    Then the response status code should be "200" with the "campaign" schema

  @UpdateCampaign
  Scenario Outline: Update a Product
    Given I set the pathParams and updated body to request
      | name     | <nameCampaign>     |
      | isActive | <isActiveCampaign> |
      | type     | <typeCampaign>     |
      | status   | <statusCampaign>   |
    When I set the "/Campaign/{id}" endpoint and send the request with updated body
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
    Given I set the pathParams to request
    When I set the "/Campaign/{id}" endpoint and send the delete request
    Then the response status code should be "204"