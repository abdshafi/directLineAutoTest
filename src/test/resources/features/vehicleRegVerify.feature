@test1
Feature: Registration Number verification

  Scenario: To verify the registration number
    Given User is on VWFSIPortal page
    When User enters the RegistrationNumber "OV12UYY"
    And Clicks on Find vehicle button
    Then I should see registration number "OV12UYY" displayed
    
  Scenario: Incorrect registration number
    Given User is on VWFSIPortal page
    When User enters the RegistrationNumber "OV12UY"
    And Clicks on Find vehicle button
    Then I should see "Sorry record not found" message displayed