Feature: Requests for Product endpoint
  @GetProducts
  Scenario: Get all Products
    Given
    When I add this "/Product2" endpoint and send the request
    Then the response status code should be "200"

  @CreateProduct
  Scenario Outline: Create a Product
    Given I build the pathParams and body to request
      | name  | <nameProduct> |
    When I add this "/Product2" endpoint and send the request with body
    Then the response status code should be "201"
    Examples:
      | nameProduct          |
      | New incoming product |

  @GetProduct
  Scenario: Get a Product
    Given I build the pathParams to request
    When I add this "/Product2/{id}" endpoint and send the request
    Then the response status code should be "200"

  @UpdateProduct
  Scenario Outline: Update a Product
    Given I build the pathParams and updated body to request
      | name  | <nameProduct> |
    When I add this "/Product2/{id}" endpoint and send the request with updated body
    Then the response status code should be "204"
    Examples:
      | nameProduct         |
      | New name of product |

  @DeleteProduct
  Scenario: Delete a Product
    Given I build the pathParams to request
    When I add this "/Product2/{id}" endpoint and send the delete request
    Then the response status code should be "204"
