Feature: Login

  Background: 
    Given Admin  gives the correct LMS portal URL

  Scenario: Validate login with valid data in all field
    When Admin enter valid data in all field and clicks login button
    Then Admin should land on home page
