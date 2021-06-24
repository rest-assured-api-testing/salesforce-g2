Feature: Requests for Product endpoint
  
  @GetProducts
  Scenario: Get all Products
    Given I build get products request "GET"
    When I add this "/Product2" endpoint and execute get products request
    Then the response status code should be "200" to get products request

  @CreateProduct
  Scenario: Create a Product
    Given I build post product request "POST"
    When I add this "/Product2" endpoint and execute post product request
    Then the response status code should be "201" to post product request

  @GetProduct
  Scenario: Get a Product
    Given I build get a product request "GET"
    When I add this "/Product2/{id}" endpoint and execute get a product request
    Then the response status code should be "200" to get a product request

  @UpdateProduct
  Scenario: Update a Product
    Given I build update product request "PATCH"
    When I add this "/Product2/{id}" endpoint and execute patch product request
    Then the response status code should be "204" to patch product request

  @DeleteProduct
  Scenario: Delete a Product
    Given I build delete a product request "DELETE"
    When I add this "/Product2/{id}" endpoint and execute delete a product request
    Then the response status code should be "204" to delete a product request