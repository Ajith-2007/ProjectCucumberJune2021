@forgotpassword
Feature: To validate Forgot password functionality

Background: 
Given User is in facebook login page
And User click forgot password link

@sanity @regression
Scenario: To validate search account feature when user forgets password using email id
When User enter invalid email id for finding the connected account
And User clicks search button
Then user must validate the error message

@sanity
Scenario: To validate search account feature when user forgets password using mobile number
When User enter invalid mobile number for finding the connected account
And User clicks search button
Then user must validate the error message for invalid mobile number

