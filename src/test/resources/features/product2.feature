Feature: Product

  @GetProducts
  Scenario: Get all Products
    Given
    When I set the "/Product2" endpoint and send the request
    Then the response status code should be "200"

  @CreateProduct
  Scenario Outline: Create a Product
    Given I set the pathParams and body to request
      | name        | <nameProduct>        |
      | productCode | <productCodeProduct> |
      | description | <descriptionProduct> |
      | isActive    | <isActiveProduct>    |
    When I set the "/Product2" endpoint and send the request with body
    Then the response status code should be "<status>" with the "responsetocreate" schema
    Examples:
      | nameProduct          | productCodeProduct | descriptionProduct     | isActiveProduct | status |
      | New incoming product | NIP1               | This is a test product | true            | 201    |
      | Incoming product     | PROD               | This is a test product | false           | 201    |
      | New product          |                    | This is a test product | true            | 201    |
      | product              | prod2              |                        | true            | 201    |
      | 555                  |                    |                        | true            | 201    |
      | .                    |                    |                        | false           | 201    |

  @GetProduct
  Scenario: Get a Product
    Given I set the pathParams to request
    When I set the "/Product2/{id}" endpoint and send the request
    Then the response status code should be "200" with the "product02" schema

  @UpdateProduct
  Scenario Outline: Update a Product
    Given I set the pathParams and updated body to request
      | name        | <nameProduct>        |
      | productCode | <productCodeProduct> |
      | description | <descriptionProduct> |
      | isActive    | <isActiveProduct>    |
    When I set the "/Product2/{id}" endpoint and send the request with updated body
    Then the response status code should be "<status>"
    Examples:
      | nameProduct     | productCodeProduct | descriptionProduct     | isActiveProduct | status |
      | Updated product | prod               | product                | false           | 204    |
      | O product       |                    | ----                   | true            | 204    |
      | Name product    |                    | This is a test product | true            | 204    |
      | product         | NIP4               |                        | false           | 204    |
      | -----           |                    | It is a  product       | false           | 204    |
      | 000             | prod2              | none                   | true            | 204    |

  @DeleteProduct
  Scenario: Delete a Product
    Given I set the pathParams to request
    When I set the "/Product2/{id}" endpoint and send the delete request
    Then the response status code should be "204"
