# UC4 Register Patient
Feature: Staff member attempts to register a patient to the PMS system

    Scenario: Staff member registers a new patient
        Given the staff member is registered
        And the staff member is logged in
        And the patient is not registered
        When the staff member registers the patient
        Then the patient is registered
        And the PMS system displays an acknowledgement message

    Scenario: Staff member registers a patient that is already registered
        Given the staff member is registered
        And the staff member is logged in
        And the patient is registered
        When the staff member registers the patient
        Then the patient is not registered
        And the PMS system displays an error message

    Scenario: Staff member registers a patient with invalid details
        Given the staff member is registered
        And the staff member is logged in
        And the patient is not registered
        When the staff member registers the patient
        Then the patient is not registered
        And the PMS system displays an error message

    Scenario: Staff member attempts to register a patient but staff member is not registered
        Given the staff member is not registered
        And the staff member is not logged in
        And the patient is not registered
        When the staff member registers the patient
        Then the patient is not registered
        And the PMS system displays an error message