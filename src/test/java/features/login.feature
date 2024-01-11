Feature: Login functionality
  As a user
  I want to be able to log in to the system
  So that I can access my account

  @testCase1, @LoginFunctionality
  Scenario Outline: Successful login from homepage
    Given the user is on the homepage
    When the user clicks the Sign in button
    Then the user should be on the Login page
    And the user enters "<email>" and "<password>"
    And clicks the login button
    Then the user should be redirected to the homepage
    And the user close the browser

    Examples:
      | email               | password |
      | lourdes100@test.com | Test123! |

    @testCase2, @LoginFunctionality
    Scenario Outline: Successful login from homepage
      Given the user is on the homepage
      When the user clicks the Sign in button
      Then the user should be on the Login page
      And the user enters "<email>" and "<password>"
      And clicks the login button
      Then the user should not be able to login
      And the user close the browser
      Examples:
        | email               | password |
        | lourdes100@test.com | wrongPass |