INSERT INTO user_account (nas, password, first_name, last_name, email, role)
VALUES
('123456789', 'password123', 'John', 'Doe', 'john.doe@example.com', 'NURSE'),
('987654321', 'password321', 'Jane', 'Smith', 'jane.smith@example.com', 'NURSE');


INSERT INTO division (division_id, division_name, location, total_beds, telephone_extension, division_status)
VALUES
('86b09124-6a22-4312-a8d1-114175a96fda', 'Cardiology', 'Building A', 10, '1234', 'INCOMPLETE'),
('2e1b83ab-b89b-4815-8264-a8e0fbf3c2e0', 'Neurology', 'Building B', 8, '5678', 'COMPLETE');

INSERT INTO staff (staff_id, role, account_id, division_id)
VALUES
('staff1', 'CHARGED_NURSE', '123456789', '86b09124-6a22-4312-a8d1-114175a96fda'),
('staff2', 'CHARGED_NURSE', '987654321', '2e1b83ab-b89b-4815-8264-a8e0fbf3c2e0');

UPDATE staff SET division_id = '86b09124-6a22-4312-a8d1-114175a96fda' WHERE staff_id = 'staff1';
UPDATE staff SET division_id = '2e1b83ab-b89b-4815-8264-a8e0fbf3c2e0' WHERE staff_id = 'staff2';



INSERT INTO room (room_id, room_status, division_id)
VALUES
('2b1d0cf3-27e7-430d-a14e-0cb9e9bae404', 'NOT_COMPLETE', '86b09124-6a22-4312-a8d1-114175a96fda'),
('f2cc4585-00e6-4e5a-a480-d68585779cdd', 'NOT_COMPLETE', '2e1b83ab-b89b-4815-8264-a8e0fbf3c2e0');


INSERT INTO beds (bed_id, bed_number, room_id)
VALUES
('353a05f7-0959-408b-a71f-67d3d5374b20', 'A101', '2b1d0cf3-27e7-430d-a14e-0cb9e9bae404'),
('0f27e476-e45c-4cef-80b8-fbfa1fda050d', 'A102', 'f2cc4585-00e6-4e5a-a480-d68585779cdd');

INSERT INTO patient_next_of_kin (kin_id, first_name, last_name, phone_number, relationship)
VALUES
('a3dc88db-2641-4ec2-9cb6-c763ac482646', 'Bob', 'Brown', '555-5678', 'FATHER');

INSERT INTO patient (nas, first_name, last_name, phone_number, dob, gender, marital_status, kin_id, street, city, country, postal_code, external_doctor_email, external_doctor_phone_number, external_doctor_first_name, external_doctor_last_name)
VALUES
('123456789', 'Alice', 'Brown', '123-555-1234', '1990-01-01', 'Female', 'Single', 'a3dc88db-2641-4ec2-9cb6-c763ac482646', '123 Main St', 'Townsville', 'Countryland', '12345', 'external@gmail.com', '444-222-1234', 'Bob', 'Doe');


INSERT INTO admission_request (admission_request_id, rationale_for_request, priority_assessment, division_id, requesting_charged_nurse_id, patient_nas)
VALUES
('e928dd89-739e-4adb-b53f-81bbf0722175', 'Urgent care needed', 10, '86b09124-6a22-4312-a8d1-114175a96fda', 'staff1', '123456789');







