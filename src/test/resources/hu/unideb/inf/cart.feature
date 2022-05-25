Feature: Testing the cart feature

  Background:
    Given the home page is opened
    And the MacBook is added to cart

  Scenario:
    When the cart page is opened
    Then the cart page total is "$602.00"

  Scenario:
    When the cart page is opened
    And the quantity field is filled with "2"
    And the quantity update button is clicked
    Then the cart page total is "$1,204.00"

  Scenario:
    When the cart page is opened
    And the quantity field is filled with "10"
    And the quantity update button is clicked
    Then the update successful message "Success: You have modified your shopping cart!" is shown

  Scenario:
    When the cart page is opened
    And the quantity field is filled with "2310"
    And the quantity update button is clicked
    Then the update error message "Products marked with *** are not available in the desired quantity or not in stock!" is shown

  Scenario:
    When the cart page is opened
    And the remove button is clicked
    And the cart page is opened
    Then the empty cart message is shown "Your shopping cart is empty!"
