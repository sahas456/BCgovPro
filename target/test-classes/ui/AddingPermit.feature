Feature: Create Permit feature

  Background: Launch the browser and navigate to login page
    Given I navigate to the Bussiness account login page

  @permit
  Scenario: UI - Create a permit with valid details - positive scenario
    Given I login to the application as a valid user
    And   I validate user is on the home page
    And   I navigate to apply permit page by selecting the permit type "Electrical"
    And   I provide all the required details for all the permit stages
    When  I submit the application and navigate back to home page
    Then  I Validate the Parcel is created and displayed in the permits list on home page
    And   I Validate the address on the parcel view page is correct

