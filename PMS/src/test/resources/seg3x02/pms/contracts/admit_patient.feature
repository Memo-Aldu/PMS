# UC8 Admit Patient
Feature: Admit patient
  Scenario: Charge Nurse admits a patient
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in
    And the Charge Nurse is consulting the patient files
    And Charge Nurse chooses to admit a Patient
    And the division is not full
    And Charge Nurse enters the admission information
    When the application command admitPatient is invoked
    Then HMS admits the patient to the division

  Scenario: Division is complete
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in
    And the Charge Nurse is consulting the patient files
    And Charge Nurse chooses to admit a Patient
    And the division is complete
    And Charge Nurse enters the admission information
    When the application command admitPatient is invoked
    Then HMS notifies Charge Nurse that her division is complete
    And HMS gives the possibility to request an admission for the Patient
