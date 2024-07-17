@smoke
  Feature: F06_categories | View Categories and brands
    Scenario: View category products
      Given categories are visible on left side bar
      When user clicks on 'Women' category
      And user clicks on any category link under 'Women' category
      Then verify that category page is displayed
      And verify text 'WOMEN - DRESS PRODUCTS' is visible
      When user clicks on any sub-category link of 'Men' category from left side bar
      Then verify user is navigated to that category page

    Scenario: View Brand Products
      When user clicks on 'Products' button
      Then verify that Brands are visible on left side bar
      When user clicks on any brand name
      Then verify that user is navigated to brand page
      And brand products are displayed
      When user clicks on any other brand link on left side bar
      Then verify that user is navigated to that brand page
      And verify that user can see products