Feature: Testing the Collection Page

  Background:
    Given the collection page is opened

  Scenario:
    When the wishlist button is clicked
    Then an error message with "You must login or create an account to save HP LP3065 to your wish list!" is shown

  Scenario:
    When the compare button is clicked
    Then an error message with "Success: You have added HP LP3065 to your product comparison!" is shown

  Scenario:
    When the category button is clicked
    Then the message "There are no products to list in this category." is shown

  Scenario:
    When the currency selector selects GBP
    Then the currency changes to GBP
