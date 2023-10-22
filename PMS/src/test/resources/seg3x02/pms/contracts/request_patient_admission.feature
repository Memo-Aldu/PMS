# UC9 Request Patient Admission
Feature: Staff member attempts to admit patient to another division

    Scenario: Staff member attempts to admit registered patient to another division
        Given that staff member is registered 
        And staff member is logged in
        And patient is registered
        And patient is not admitted to any division
        When staff member attempts to admit patient to another division
        Then patient is admitted to another division
        And the PMS system displays a message that patient is admitted to another division

    Scenario: Staff member attempts to transfer a registered patient to from one division to another
        Given that staff memeber is registered
        And staff member is logged in
        And patient is registered
        And patient is admitted to a division
        When staff member attempts to transfer patient to another division
        Then patient is transferred to another division
        And the PMS system displays a message that patient is transferred to another division

    Scenario: Staff member attempts to admit a non-registered patient to a division
        Given that staff member is registered
        And staff member is logged in
        And patient is not registered
        When staff member attempts to admit patient to a division
        Then patient is not admitted to a division
        And the PMS system displays a message that patient is not registered in the PMS system

    Scenario: Staff member attempts to transfer a non-registered patient to another division
        Given that staff member is registered
        And staff member is logged in
        And patient is not registered
        When staff member attempts to transfer patient to another division
        Then patient is not transferred to another division
        And the PMS system displays a message that patient is not registered in the PMS system

    Scenario: Staff member attempts to tranfer a registered patient that is not admitted in any division
        Given that staff member is registered
        And staff member is logged in
        And patient is registered
        And patient is not admitted to any division
        When staff member attempts to transfer patient to another division
        Then patient is not transferred to another division
        And the PMS system displays a message that patient is not admitted to any division

    Scenario: Staff member attempts to discharge a registered patient
        Given that staff member is registered
        And staff member is logged in
        And patient is registered
        And patient is admitted to a division
        And patient is cured
        And patient is not discharged
        When staff member attempts to discharge patient
        Then patient is discharged
        And the PMS system displays a message that patient is discharged