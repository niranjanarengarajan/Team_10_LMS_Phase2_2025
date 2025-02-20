  @HomePage
Feature: Home Page

 Background: Admin gives the correct LMS portal URL
 Given Admin is on login Page
  When Admin enters valid data in all field and  clicks login button

  @HP1
  Scenario: Verify LMS title
  Then Admin should see "LMS" as title
  
    #@HP2
  #Scenario: Verify LMS title alignmen
    #Then LMS title should be on the top left corner of page