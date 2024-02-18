Feature: Place order
  This feature deals with order placing on Automation Exercise web application

  Scenario: Register while Checkout
    Given Launch browser
    When  Navigate to url 'http://automationexercise.com'
    Then  Verify that home page is visible successfully
    When  Add products to cart
    When  Click 'Cart' button
    Then  Verify that cart page is displayed
    When  Click 'Proceed To Checkout' button
    When  Click 'Register Login' button
    When  Fill all details in Signup and create account
    Then  Verify 'ACCOUNT CREATED!' and click 'Continue' button
    When  Verify ' Logged in as username' at top
    Then  Click 'Cart' button2
    When  Click 'Proceed To Checkout' button
    When  Verify Address Details and Review Your Order
    When  Enter description in comment text area and click 'Place Order'
    Then  Enter payment details
    When  Click Pay and Confirm Order button
    When  Verify success message 'Your order has been placed successfully!'
    When  Click 'Delete Account' button
    Then  Verify ACCOUNT DELETED! and click Continue button


