@login
Feature: Test Login feature

  Background: Launch the browser and navigate to login page
    Given I navigate to the swaglabs login page
    And I verify the login page title

  Scenario: UI - Login as a standard user
    When I login to the application as a standard user
    And  I validate user is on the Inventory page
    Then I validate add to cart functionality is working fine

  Scenario: UI - Login as a Locked out user
    When I login to the application as a locked_out user
    Then I validate the user is locked out

  Scenario: UI - Login as a Problem user
    When I login to the application as a problem user
    And  I validate user is on the Inventory page
    Then I validate add to cart functionality is not working fine

  Scenario: UI - Login as a performance glitch user
    When I login to the application as a performance_glitch_user user
    Then I validate the pages are loading slowly

  Scenario:UI - Login test with Invalid credentials
    When I enter invalid credentials and click login button
    Then I see error message displayed



