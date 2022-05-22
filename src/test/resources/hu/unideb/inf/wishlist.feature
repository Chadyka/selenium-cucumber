Feature: Testing the Home page

  Background:
    Given the home page is opened

  Scenario:
    When the wishlist button is clicked
    Then a "login" error message is shown

  Scenario:
    When the MacBook is added to cart
    And the home page is opened
    Then the cart total is "1 item(s) - $602.00"