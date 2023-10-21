# UC8 Admit Patient
Feature: Admit patient
  Scenario: Charge Nurse admits a patient
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in 
    And the use case Consult File is included
    When Charge Nurse chooses the admit fonctionality for a Patient
    And HMS-PMS asks for room and bed number
    And Charge Nurse enters room and bed number or alternatively browses through a list of available
rooms and beds in the ward and makes a selection 
    And HMS asks for the remaining admission information
    And Charge Nurse enters requested information
    Then HMS admits the patient

  Scenario: Division is complete
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in
    And the use case Consult File is included
    And the division is complete
    When Charge Nurse chooses to admit the patient
    Then HMS notifies Charge Nurse that her division is complete
    And HMS gives the possibility to request an admission for the Patient as in use case Request Patient Admission
