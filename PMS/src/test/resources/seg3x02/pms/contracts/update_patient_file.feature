#UC6 Update Patient Files
Feature: Staff member attempts to update a patients file

    Scenario: Staff member attempts to update a registered patients file
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is registered
        And the patient's file is open
        When the application command "updatePatientFile" is invoked
        Then the system updates the patients file
        And the system displays a message that the file has been updated
        And the system displays the updated file

    Scenario: Staff member updates a patients file with invalid information
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is registered
        And the patient's file is open
        And the patient's details are invalid
        When the application command "updatePatientFile" is invoked
        Then the system does not update the patients file
        And the patient's file is not updated
        And the system displays an error message

    Scenario: Staff member updates a patients file but patient is not registered
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is not registered
        When the application command "updatePatientFile" is invoked
        Then the system does not update the patients file
        And the system displays an error message

    Scenario: A non-registered staff member attempts to update a patients file
        Given the HMS-PMS system is running
        And staff member is not logged in
        And patient is or is not registered
        When the application command "updatePatientFile" is invoked
        Then the system does not update the patients file
        And the system displays an error message