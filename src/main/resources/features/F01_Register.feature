@smoke
  Feature: F01_Register | Register New User
    Scenario: Guest user could register with valid data successfully
      Given homepage is visible successfully
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
      And verify that 'Logged in as username' is visible