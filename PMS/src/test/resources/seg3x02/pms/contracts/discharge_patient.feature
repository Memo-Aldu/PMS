# UC11 Discharge Patient
Feature: Discharge Patient

  Scenario: Charge Nurse discharges a Patient
    Given the HMS-PMS is On 
    And the Charge Nurse is logged in 
    And the use case Consult File is included
    And the Charge Nurse selects the discharge option of a Patient
    When the application command dischargePatient is invoked
    Then the HMS-PMS displays an acknowledgement message
    And the HMS-PMS updates bed availability
    And the patient is discharged
    And the discharged Patient's information are printed
