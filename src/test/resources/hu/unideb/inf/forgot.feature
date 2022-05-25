Feature: Testing the forgot password page

  Background:
    Given the forgot password page is opened

  Scenario Outline:
    Given the forgotten email field is filled with '<parameter>'
    When the forgotten page Sign In button is clicked
    Then the '<msg>' error message is shown on the forgotten password page
    Examples:
      | parameter         | msg                                                                         |
      |                   | Warning: The E-Mail Address was not found in our records, please try again! |
      | invalid.email.com | Warning: The E-Mail Address was not found in our records, please try again! |
      | valid@email.com   | Warning: The E-Mail Address was not found in our records, please try again! |
      | 123@456.com       | Warning: The E-Mail Address was not found in our records, please try again! |
