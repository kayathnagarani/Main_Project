Feature: Return Event Details
@sanity
  Scenario: Retrieving event deatils
    Given the user is homepage
    When user clicks on Mybooking
    And user clicks on cityArrow and selects new city
    And clicks on fitnessandwellbeing
    And clicks on dateArrow and select thisweekend and enables listview
    Then events are printed
    And scrolls until popular cities
    And prints city names
    
 
