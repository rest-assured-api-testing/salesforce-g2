Feature: Requests for Product endpoint
  
  @GetProducts
  Scenario: Get all Products
    Given 
    When I add this "/Product2" endpoint and execute "GETPRODUCTS" request
    Then the response status code should be "200" to "THENPRODUCTS" request

  @GetProduct
  Scenario: Get a Product
    Given I build "GIVENGETDELETEPRODUCT" request
    When I add this "/Product2/{id}" endpoint and execute "GETPRODUCTS" request
    Then the response status code should be "200" to "THENPRODUCTS" request

  @CreateProduct
  Scenario: Create a Product
    Given I build "GIVENCREATEPRODUCT" request
    When I add this "/Product2" endpoint and execute "POSTPRODUCT" request
    Then the response status code should be "201" to "THENPRODUCTS" request

  @UpdateProduct
  Scenario: Update a Product
    Given I build "GIVENUPDATEPRODUCT" request
    When I add this "/Product2/{id}" endpoint and execute "PATCHPRODUCT" request
    Then the response status code should be "204" to "THENPRODUCTS" request

  @DeleteProduct
  Scenario: Delete a Product
    Given I build "GIVENGETDELETEPRODUCT" request
    When I add this "/Product2/{id}" endpoint and execute "DELETEPRODUCT" request
    Then the response status code should be "204" to "THENPRODUCTS" request