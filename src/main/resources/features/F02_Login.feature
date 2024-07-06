@smoke
  Feature: F02_Login | User Login
    Scenario: User could login with correct email and password
      Given homepage is visible successfully
      When user clicks on 'Signup-Login' button
      Then verify 'Login to your account' is visible
      When user enters correct email
      And user enters correct password
      And user clicks login button
      Then verify that 'Logged in as username' is visible