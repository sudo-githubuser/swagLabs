Feature: Login
  Description: Testing login scenario in swag labs

  Rule: User login in swag labs
    Background:
      Given User lands on login page
      Then User is in "swag labs" homepage


Scenario: Successful login as standard user
  When Enters username "standard_user"
  * Enters password "secret_sauce"
  Then User logged in successfully

Scenario: Login as locked-out-user
  When Enters username "locked_out_user"
  * Enters password "secret_sauce"
  Then "User is locked out" message is displayed
  And login is unsuccessful

Scenario: Login as problem-user
  When Enters username "problem_user"
  * Enters password "secret_sauce"
  Then User logged in successfully

Scenario: Login as performance-glitch-user
  When Enters username "performance_glitch_user"
  * Enters password "secret_sauce"
  Then User logged in successfully

Scenario: Login as error-user
  When Enters username "error_user"
  * Enters password "secret_sauce"
  Then User logged in successfully

Scenario: Login as visual-user
  When Enters username "visual_user"
  * Enters password "secret_sauce"
  Then User logged in successfully