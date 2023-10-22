# UC5 Consult Patient Files, not needed for livable 1 I believe

Feature: Consult Patient File
  Scenario: Staff Member views a Patient file
    Given the HMS is ON
    And the Staff Member is logged in
    When Staff Member asks for viewing Patient registration
    And HMS asks for Patient identification number
    And Medical staff member enters Patient identification number
    Then HMS shows the Patient registration information

  Scenario: Incorrect Patient Identification Number
    Given the HMS is ON
    And the Staff Member is logged in
    When Staff Member asks for viewing Patient registration
    And HMS asks for Patient identification number
    And Medical staff member enters an incorrect Patient identification number
    Then HMS displays a Patient not found error message
