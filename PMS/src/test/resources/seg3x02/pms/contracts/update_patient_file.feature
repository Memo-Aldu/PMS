#UC6 Update Patient Files
Feature: Staff member attempts to update a patients file

    Scenario: Staff member updates a registered patients file
        Given a staff member is registered
        And staff member is logged in
        And patient is registered
        When staff member updates a patients file
        Then the patient file is updated
        And the system displays a message that the file has been updated

    Scenario: Staff member updates a patients file with invalid information
        Given a staff member is registered
        And staff member is logged in
        And patient is registered
        When staff member updates a patients file with invalid information
        Then the patient file is not updated
        And the system displays an error message

    Scenario: Staff member updates a patients file but patient is not registered
        Given a staff member is registered
        And staff member is logged in
        And patient is not registered
        When staff member updates a patients file
        Then the patient file is not updated
        And the system displays an error message

    Scenario: A non-registered staff member attempts to update a patients file
        Given a staff member is not registered
        And staff member is not logged in
        And patient is or is not registered
        When staff member updates a patients file
        Then the patient file is not updated
        And the system displays an error message