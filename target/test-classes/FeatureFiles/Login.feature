@Login
Feature: To validate login functionality

  Background: 
    Given User is in facebook login page
    
    
  @smoke
  Scenario: To validate login using invalid credentials
    When User enter invalid username and password
      | username | password   |
      | greens   | greens@123 |
      | sql      | sql@123    |
      | python   | python@123 |
    And User click login button
    Then User must be in invalid credentials page

  @regression
  Scenario: To validate login without entering required credentials
    When User click login button
    Then User must be in invalid credentials page
