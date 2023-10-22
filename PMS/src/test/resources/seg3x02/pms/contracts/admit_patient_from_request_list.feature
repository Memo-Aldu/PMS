# UC10 Admit patient from request list
Feature: Admit patient from request list
  Scenario: Charge Nurse admits a patient from the request list
    Given the HMS is On 
    And the Charge Nurse is logged in 
    And the Patient is in the request list
    And Charge Nurse selects a patient
    When the application command admitPatientFromRequestList is invoked
    Then HMS displays the selected Patient registration
    And perform admission as in use case Admit Patient (steps 2 - )

  Scenario: Patient cannot be admitted
    Given the HMS is On 
    And the Charge Nurse is logged in
    And the Patient is in the request list
    And the Patient cannot be admitted
    When the application command admitPatientFromRequestList is invoked
    Then Charge Nurse denies Patient admission
    And HMS sends a notification to the Charge Nurse who requested admission
