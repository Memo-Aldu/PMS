# UC8 Admit Patient
Feature: Admit patient
  Scenario: Charge Nurse admits a patient
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in 
    And the use case Consult File is included
    And Charge Nurse chooses to admit a Patient
    And HMS-PMS asks for room and bed number
    And Charge Nurse enters room 
    And the Charge Nurse enters the bed number 
    And  Charge Nurse enters remaining admission information
    When the application command admitPatient is invoke
    Then HMS admits the patient

  Scenario: Charge Nurse admits a patient
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in 
    And the use case Consult File is included
    And Charge Nurse chooses to admit a Patient
    And HMS-PMS asks for room and bed number
    And the Charge nurse selects a rooms list of available rooms
    And a beds in the ward
    And  Charge Nurse enters remaining admission information
    When the application command admitPatient is invoke
    Then HMS admits the patient

  Scenario: Division is complete
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in
    And the use case Consult File is included
    And the division is complete
    When the application command admitPatient is invoke
    Then HMS notifies Charge Nurse that her division is complete
    And HMS gives the possibility to request an admission for the Patient as in use case Request Patient Admission
