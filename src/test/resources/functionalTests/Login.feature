Feature: Login
  Description: Testing login scenario in swag labs

  Rule: User login in swag labs
    Background:
      Given User enters "URL" in the "browser"
      Then User is in "swag labs" homepage


Scenario: Successful login as standard user
  When Enters "standard_user"
  * Enters "secret_sauce"
  Then User logged in successfully

Scenario: Login as locked-out-user
  When Enters "locked_out_user"
  * Enters "secret_sauce"
  Then "User is locked out" message is displayed
  And login is unsuccessful

Scenario: Login as problem-user
  When Enters "problem_user"
  * Enters "secret_sauce"
  Then User logged in successfully

Scenario: Login as performance-glitch-user
  When Enters "performance_glitch_user"
  * Enters "secret_sauce"
  Then User logged in successfully

Scenario: Login as error-user
  When Enters "error_user"
  * Enters "secret_sauce"
  Then User logged in successfully

Scenario: Login as visual-user
  When Enters "visual_user"
  * Enters "secret_sauce"
  Then User logged in successfully