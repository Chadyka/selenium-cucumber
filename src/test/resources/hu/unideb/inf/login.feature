Feature: Testing the Login page

  Background:
    Given the login page is opened

  Scenario Outline:
    Given the email field is filled with '<parameter>'
    When the Sign In button is clicked
    Then the '<msg>' error message is shown
    Examples:
      | parameter         | msg                                                   |
      |                   | Warning: No match for E-Mail Address and/or Password. |
      | invalid.email.com | Warning: No match for E-Mail Address and/or Password. |
      | valid@email.com   | Warning: No match for E-Mail Address and/or Password. |
      | 123@gmail.com     | Warning: No match for E-Mail Address and/or Password. |
