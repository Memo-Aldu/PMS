# UC9 Request Patient Admission
Feature: Staff member attempts to admit patient to another division

    Scenario: Staff member attempts to admit registered patient to another division
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is registered
        And patient is not admitted to any division
        When the application command "admitToDivision" is invoked
        Then patient is admitted to a division
        And the system invokes "updatePatientFile" command
        And the system saves the patient's division
        And the PMS system displays a message that patient is admitted to another division

    Scenario: Staff member attempts to transfer a registered patient to from one division to another
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is registered
        And patient is admitted to a division
        When the system command "transferToDivision" is invoked
        Then patient is transferred to another division
        And the system invokes "updatePatientFile" command
        And the system updates the patient's division inside the file
        And the PMS system displays a message that patient is transferred to another division

    Scenario: Staff member attempts to admit a non-registered patient to a division
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is not registered
        When the application command "admitToDivision" is invoked
        Then patient is not admitted to a division
        And the PMS system displays a message that patient is not registered in the PMS system

    Scenario: Staff member attempts to transfer a non-registered patient to another division
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is not registered
        When the application command "transferToDivision" is invoked    
        Then patient is not transferred to another division
        And the PMS system displays a message that patient is not registered in the PMS system

    Scenario: Staff member attempts to tranfer a registered patient that is not admitted in any division
        Given the HMS-PMS system is running
        And staff member is logged in
        And patient is registered
        And patient is not admitted to any division
        When the application command "transferToDivision" is invoked
        Then patient is not transferred to another division
        And the PMS system displays a message that patient is not admitted to any division
