@smoke
  Feature: F04_cart | Add Products to Cart
    Background:
      Given homepage is visible successfully

    Scenario: User can add products to cart
      When user clicks on 'Products' button
      And user hovers over the first product and clicks 'Add to cart'
      And user clicks 'Continue Shopping' button
      And user hovers over the second product and clicks 'Add to cart'
      And user clicks 'View Cart' button
      Then verify both products are added to cart
      And verify their prices, quantity, and total price

    Scenario Outline: Verify product quantity in cart
      When user clicks 'View Product' for any product on homepage
      Then verify product page is opened
      When user increases product quantity to "<quantity>"
      And user clicks 'Add to cart' button
      And user clicks 'View Cart' button
      Then verify that the product is displayed in cart page with exact quantity
      Examples:
        | quantity |
        |        4 |