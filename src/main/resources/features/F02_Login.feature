@smoke
  Feature: F02_Login | User Login
    Scenario: User can login with correct email and password
      Given homepage is visible successfully
      When user clicks on 'Signup-Login' button
      Then verify 'Login to your account' is visible
      When user enters correct email
      And user enters correct password
      And user clicks login button
      Then verify that 'Logged in as username' is visible

    Scenario Outline: User cannot login with incorrect email and password
      Given homepage is visible successfully
      When user clicks on 'Signup-Login' button
      Then verify 'Login to your account' is visible
      When user enters incorrect email "<email@abc.com>"
      And user enters incorrect password "<password>"
      And user clicks login button
      Then verify error 'Your email or password is incorrect!' is visible
      Examples:
        | email@abc.com   | password |
        | abc3000@abc.com | abc3000  |