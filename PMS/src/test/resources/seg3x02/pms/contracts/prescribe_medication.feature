# UC12 Prescribe Medication
Feature: Staff member tries to prescribe medication to a patient

    Scenario: Staff member prescribes medication to a patient that is registered
        Given the HMS-PMS is running
        And the staff member is logged in
        And patient is registered
        And the medication is in the system
        When the application command "prescribeMedication" is invoked
        Then the HMS-PMS prescribes the medication to the patient
        And the system displays a success message
        And the medication is added to the patient's medication list

    Scenario: Staff member prescribes medication to a patient that is not registered
        Given the HMS-PMS is running
        And the staff member is logged in
        And patient is not registered
        And the medication is in the system
        When the application command "prescribeMedication" is invoked by the staff member
        Then the HMS-PMS doesn't prescribe the medication to the patient
        And the system displays an error message
        And the medication isn't added to the patient's medication list

    Scenario: Staff member prescribes medication to a patient that is registered but the medication is not in the system
        Given the HMS-PMS is running
        And the staff member is logged in
        And the patient is registered
        And the medication is not in the system
        When the application command "prescribeMedication" is invoked by the staff member
        Then the patient is not prescribed the medication
        And the system displays an error message
        And the medication isn't added to the patient's medication list