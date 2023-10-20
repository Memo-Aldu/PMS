Feature: Staff Member attempts to register to the HMS system to identify himself/herself to the system
  to use its functionalities.


    Scenario: The HMS is On, and a Staff Member successfully registers to the HMS system
      Given the HMS system is running
      And the staff member selects to register to the system
      And the HMS asks for the staff member's information
      And the staff member provides all the required information
      When the application command registerStaff is invoked
      Then the staff member is registered to the system
      And the HMS displays an acknowledgement message


    Scenario: The HMS is On, and Staff Member provides incomplete information to register to the HMS system
      Given the HMS system is running
      And the staff member selects to register to the system
      And the HMS asks for the staff member's information
      And the staff member provides incomplete information
      When the application command registerStaff is invoked
      Then the staff member is not registered to the system
      And the HMS displays an incomplete information error message


    Scenario: The HMS is On, and Staff Member tries to register to the HMS but is not found in the system
      Given the HMS system is running
      And the staff member selects to register to the system
      And the HMS asks for the staff member's information
      And the staff member provides all the required information
      And the staff member is not found in the system
      When the application command registerStaff is invoked
      Then the staff member is not registered to the system
      And the HMS displays an invalid user error message
