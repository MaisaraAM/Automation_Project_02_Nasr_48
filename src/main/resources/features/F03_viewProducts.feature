@smoke
  Feature: F03_viewProducts | View and Search Products
    Background:
      Given homepage is visible successfully

    Scenario: User can view products list and product details
      When user clicks on 'Products' button
      Then verify user is navigated to ALL PRODUCTS page successfully
      And the products list is visible
      When user click on 'View Product' of first product
      Then user is landed to product detail page
      And verify that product details are visible

    Scenario: User can search for products
      When user clicks on 'Products' button
      Then verify user is navigated to ALL PRODUCTS page successfully
      When user enters product name in search input
      And user clicks search button
      Then verify 'SEARCHED PRODUCTS' is visible
      And verify all the products related to search are visible