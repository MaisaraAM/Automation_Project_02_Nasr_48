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