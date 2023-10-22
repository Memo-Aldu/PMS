# UC12 Prescribe Medication
Feature: Staff member tries to prescribe medication to a patient

    Scenario: Staff member prescribes medication to a patient that is registered
        Given the patient is registered 
        And the staff member is logged in
        And the medication is in the system
        When the staff member prescribes the medication to the patient
        Then the patient is prescribed the medication
        And the system displays a success message

    Scenario: Staff member prescribes medication to a patient that is not registered
        Given the patient is not registered 
        And the staff member is logged in
        And the medication is in the system
        When the staff member prescribes the medication to the patient
        Then the patient is not prescribed the medication
        And the system displays an error message

    Scenario: Staff member prescribes medication to a patient that is registered but the medication is not in the system
        Given the patient is registered 
        And the staff member is logged in
        And the medication is not in the system
        When the staff member prescribes the medication to the patient
        Then the patient is not prescribed the medication
        And the system displays an error message