Feature: Accommodation Feature

Scenario: Accommodation Selection Check
  Given User is on POI page
  When Page title is  "Visualize points of interest (POIs) on a map, build it with our API - Targomo"
  When user clicks the Accommodation Button
  Then Accommodation Button Should be Selected

