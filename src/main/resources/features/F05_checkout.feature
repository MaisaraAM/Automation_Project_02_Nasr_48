@smoke
Feature: F05_checkout | Place orders
  Background:
    Given homepage is visible successfully

  Scenario: Verify address details in checkout page
    When user clicks on 'Signup-Login' button
    Then verify 'New User Signup!' is visible
    When user enters username
    And user enters email
    And user clicks signup button
    Then verify that 'ENTER ACCOUNT INFORMATION' is visible
    When user enters password
    And user enters date of birth
    And user selects newsletter checkbox
    And user selects offers checkbox
    And user enters first name
    And user enters last name
    And user enters address
    And user enters country
    And user enters state
    And user enters city
    And user enters zipcode
    And user enters mobile number
    And user clicks create account button
    Then verify that 'ACCOUNT CREATED!' is visible
    When user clicks continue button
    Then verify that 'Logged in as username' is visible
    When user hovers over the first product and clicks 'Add to cart'
    And user clicks 'View Cart' button
    Then verify that cart page is displayed
    When user clicks 'Proceed To Checkout' button
    Then verify the delivery address
    And verify the billing address
    When user clicks on 'Delete Account' button
    Then verify 'ACCOUNT DELETED!' is visible
    When user clicks continue button
    Then homepage is visible successfully

  Scenario: Register while Checkout
    When user hovers over the first product and clicks 'Add to cart'
    And user clicks 'View Cart' button
    Then verify that cart page is displayed
    When user clicks 'Proceed To Checkout' button
    And user clicks 'Register-Login' button
    And user enters username
    And user enters email
    And user clicks signup button
    And user enters password
    And user enters date of birth
    And user selects newsletter checkbox
    And user selects offers checkbox
    And user enters first name
    And user enters last name
    And user enters address
    And user enters country
    And user enters state
    And user enters city
    And user enters zipcode
    And user enters mobile number
    And user clicks create account button
    Then verify that 'ACCOUNT CREATED!' is visible
    When user clicks continue button
    Then verify that 'Logged in as username' is visible
    When user clicks on 'Cart' button
    And user clicks 'Proceed To Checkout' button
    Then verify the delivery address
    And verify the billing address
    And review the order
    When user enters description in comment text area
    And user clicks 'Place Order'
    And user enters payment details: name on card
    And user enters card number
    And user enters cvc
    And user enters expiration date
    And user clicks 'Pay and Confirm Order' button
    Then verify success message 'Your order has been placed successfully!' is visible
    When user clicks on 'Delete Account' button
    Then verify 'ACCOUNT DELETED!' is visible
    When user clicks continue button
    Then homepage is visible successfully