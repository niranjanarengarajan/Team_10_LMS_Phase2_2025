Feature:Program


Background: Admin is logged in to LMS Portal
Given The Browser is open
When Log into LMS Portal as Admin

@ProgramLogin
Scenario: Verify that Admin is able to navigate to Program page
Given Admin is on home page after Login
When Admin clicks "Program" on the navigation bar
Then Admin should be navigated to "Program" page

