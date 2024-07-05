@smoke
  Feature: F01_Register | Register New User
    Scenario: Guest user could register with valid data successfully
      Given website homepage is visible
      When user goes to register page
      And user enters username
      And user enters email
      And user clicks signup button
      And user enters password
      And user enters date of birth
      And user selects newsletter checkbox
      And user selects offers checkbox
#      And user enters first name
#      And user enters last name
#      And user enters address
#      And user enters country
#      And user enters state
#      And user enters city
#      And user enters zipcode
#      And user enters mobile number
#      And user clicks create account button
#      Then success message is displayed