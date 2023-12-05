CREATE TABLE IF NOT EXISTS user_account
(
    nas        VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    role       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user_account PRIMARY KEY (nas)
);

CREATE TABLE IF NOT EXISTS staff
(
    staff_id    VARCHAR(255) NOT NULL,
    role        VARCHAR(20)  NOT NULL,
    account_id  VARCHAR(255) NOT NULL,
    division_id UUID         NOT NULL,
    CONSTRAINT pk_staff PRIMARY KEY (staff_id)
);

ALTER TABLE IF EXISTS staff
    DROP CONSTRAINT IF EXISTS uc_staff_account;

ALTER TABLE IF EXISTS staff
    ADD CONSTRAINT uc_staff_account UNIQUE (account_id);

ALTER TABLE IF EXISTS staff
    DROP CONSTRAINT IF EXISTS FK_STAFF_ON_ACCOUNT;

ALTER TABLE IF EXISTS staff
    ADD CONSTRAINT FK_STAFF_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES user_account (nas);


CREATE TABLE IF NOT EXISTS division
(
    division_id         UUID                             NOT NULL,
    division_name       VARCHAR(255)                     NOT NULL,
    location            VARCHAR(255)                     NOT NULL,
    total_beds          INTEGER                          NOT NULL,
    telephone_extension VARCHAR(255),
    division_status     VARCHAR(20) DEFAULT 'INCOMPLETE' NOT NULL,
    charge_nurse_id     VARCHAR(255),
    CONSTRAINT pk_division PRIMARY KEY (division_id)
);

ALTER TABLE IF EXISTS division
    DROP CONSTRAINT IF EXISTS uc_division_division_name;

ALTER TABLE IF EXISTS division
    ADD CONSTRAINT uc_division_division_name UNIQUE (division_name);

ALTER TABLE IF EXISTS division
    DROP CONSTRAINT IF EXISTS FK_DIVISION_ON_CHARGE_NURSE;

ALTER TABLE IF EXISTS division
    ADD CONSTRAINT FK_DIVISION_ON_CHARGE_NURSE FOREIGN KEY (charge_nurse_id) REFERENCES staff (staff_id);

ALTER TABLE IF EXISTS staff
    DROP CONSTRAINT IF EXISTS FK_STAFF_ON_DIVISION;

ALTER TABLE IF EXISTS staff
    ADD CONSTRAINT FK_STAFF_ON_DIVISION FOREIGN KEY (division_id) REFERENCES division (division_id);


CREATE TABLE IF NOT EXISTS beds
(
    bed_id     UUID         NOT NULL,
    bed_number VARCHAR(255) NOT NULL,
    room_id    UUID         NOT NULL,
    CONSTRAINT pk_beds PRIMARY KEY (bed_id)
);

ALTER TABLE IF EXISTS beds
    DROP CONSTRAINT IF EXISTS uc_beds_bed_number;

ALTER TABLE IF EXISTS beds
    ADD CONSTRAINT uc_beds_bed_number UNIQUE (bed_number);


CREATE TABLE IF NOT EXISTS room
(
    room_id     UUID                               NOT NULL,
    room_status VARCHAR(20) DEFAULT 'NOT_COMPLETE' NOT NULL,
    division_id UUID                               NOT NULL,
    CONSTRAINT pk_room PRIMARY KEY (room_id)
);

ALTER TABLE IF EXISTS room
    DROP CONSTRAINT IF EXISTS FK_ROOM_ON_DIVISION;

ALTER TABLE IF EXISTS room
    ADD CONSTRAINT FK_ROOM_ON_DIVISION FOREIGN KEY (division_id) REFERENCES division (division_id);

ALTER TABLE IF EXISTS beds
    DROP CONSTRAINT IF EXISTS FK_BEDS_ON_ROOM;

ALTER TABLE IF EXISTS beds
    ADD CONSTRAINT FK_BEDS_ON_ROOM FOREIGN KEY (room_id) REFERENCES room (room_id);


CREATE TABLE IF NOT EXISTS patient
(
    nas                          VARCHAR(255) NOT NULL,
    first_name                   VARCHAR(255) NOT NULL,
    last_name                    VARCHAR(255) NOT NULL,
    phone_number                 VARCHAR(255) NOT NULL,
    dob                          date         NOT NULL,
    gender                       VARCHAR(255) NOT NULL,
    marital_status               VARCHAR(255) NOT NULL,
    kin_id                       UUID         NOT NULL,
    street                       VARCHAR(255),
    city                         VARCHAR(255),
    country                      VARCHAR(255),
    postal_code                  VARCHAR(255),
    external_doctor_first_name   VARCHAR(255),
    external_doctor_last_name    VARCHAR(255),
    external_doctor_phone_number VARCHAR(255),
    external_doctor_email        VARCHAR(255),
    CONSTRAINT pk_patient PRIMARY KEY (nas)
);


CREATE TABLE IF NOT EXISTS patient_next_of_kin
(
    kin_id       UUID         NOT NULL,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    relationship VARCHAR(255) NOT NULL,
    street       VARCHAR(255),
    city         VARCHAR(255),
    country      VARCHAR(255),
    postal_code  VARCHAR(255),
    CONSTRAINT pk_patient_next_of_kin PRIMARY KEY (kin_id)
);

ALTER TABLE IF EXISTS patient
    DROP CONSTRAINT IF EXISTS FK_PATIENT_ON_KIN;

ALTER TABLE IF EXISTS patient
    ADD CONSTRAINT FK_PATIENT_ON_KIN FOREIGN KEY (kin_id) REFERENCES patient_next_of_kin (kin_id);


CREATE TABLE IF NOT EXISTS admission_request
(
    admission_request_id        UUID         NOT NULL,
    rationale_for_request       VARCHAR(255) NOT NULL,
    priority_assessment         INTEGER      NOT NULL,
    division_id                 UUID         NOT NULL,
    requesting_charged_nurse_id VARCHAR(255) NOT NULL,
    patient_nas                 VARCHAR(255) NOT NULL,
    CONSTRAINT pk_admission_request PRIMARY KEY (admission_request_id)
);

ALTER TABLE IF EXISTS admission_request
    DROP CONSTRAINT IF EXISTS FK_ADMISSION_REQUEST_ON_DIVISION;

ALTER TABLE IF EXISTS admission_request
    ADD CONSTRAINT FK_ADMISSION_REQUEST_ON_DIVISION FOREIGN KEY (division_id) REFERENCES division (division_id);

ALTER TABLE IF EXISTS admission_request
    DROP CONSTRAINT IF EXISTS FK_ADMISSION_REQUEST_ON_PATIENT_NAS;

ALTER TABLE IF EXISTS admission_request
    ADD CONSTRAINT FK_ADMISSION_REQUEST_ON_PATIENT_NAS FOREIGN KEY (patient_nas) REFERENCES patient (nas);

ALTER TABLE IF EXISTS admission_request
    DROP CONSTRAINT IF EXISTS FK_ADMISSION_REQUEST_ON_REQUESTING_CHARGED_NURSE;

ALTER TABLE IF EXISTS admission_request
    ADD CONSTRAINT FK_ADMISSION_REQUEST_ON_REQUESTING_CHARGED_NURSE FOREIGN KEY (requesting_charged_nurse_id) REFERENCES staff (staff_id);



CREATE TABLE IF NOT EXISTS patient_admission
(
    admission_id                UUID         NOT NULL,
    room_id                     UUID         NOT NULL,
    bed_id                      UUID         NOT NULL,
    patient_nas                 VARCHAR(255) NOT NULL,
    division_id                 UUID         NOT NULL,
    requesting_charged_nurse_id VARCHAR(255) NOT NULL,
    accepting_charged_nurse_id  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_patient_admission PRIMARY KEY (admission_id)
);

ALTER TABLE IF EXISTS patient_admission
    DROP CONSTRAINT IF EXISTS FK_PATIENT_ADMISSION_ON_ACCEPTING_CHARGED_NURSE;

ALTER TABLE IF EXISTS patient_admission
    ADD CONSTRAINT FK_PATIENT_ADMISSION_ON_ACCEPTING_CHARGED_NURSE FOREIGN KEY (accepting_charged_nurse_id) REFERENCES staff (staff_id);

ALTER TABLE IF EXISTS patient_admission
    DROP CONSTRAINT IF EXISTS FK_PATIENT_ADMISSION_ON_BED;

ALTER TABLE IF EXISTS patient_admission
    ADD CONSTRAINT FK_PATIENT_ADMISSION_ON_BED FOREIGN KEY (bed_id) REFERENCES beds (bed_id);

ALTER TABLE IF EXISTS patient_admission
    DROP CONSTRAINT IF EXISTS FK_PATIENT_ADMISSION_ON_DIVISION;

ALTER TABLE IF EXISTS patient_admission
    ADD CONSTRAINT FK_PATIENT_ADMISSION_ON_DIVISION FOREIGN KEY (division_id) REFERENCES division (division_id);

ALTER TABLE IF EXISTS patient_admission
    DROP CONSTRAINT IF EXISTS FK_PATIENT_ADMISSION_ON_PATIENT_NAS;

ALTER TABLE IF EXISTS patient_admission
    ADD CONSTRAINT FK_PATIENT_ADMISSION_ON_PATIENT_NAS FOREIGN KEY (patient_nas) REFERENCES patient (nas);

ALTER TABLE IF EXISTS patient_admission
    DROP CONSTRAINT IF EXISTS FK_PATIENT_ADMISSION_ON_REQUESTING_CHARGED_NURSE;

ALTER TABLE IF EXISTS patient_admission
    ADD CONSTRAINT FK_PATIENT_ADMISSION_ON_REQUESTING_CHARGED_NURSE FOREIGN KEY (requesting_charged_nurse_id) REFERENCES staff (staff_id);

ALTER TABLE IF EXISTS patient_admission
    DROP CONSTRAINT IF EXISTS FK_PATIENT_ADMISSION_ON_ROOM;

ALTER TABLE IF EXISTS patient_admission
    ADD CONSTRAINT FK_PATIENT_ADMISSION_ON_ROOM FOREIGN KEY (room_id) REFERENCES room (room_id);


CREATE TABLE IF NOT EXISTS patient_discharge
(
    discharge_id       UUID                        NOT NULL,
    discharge_reason   VARCHAR(255)                NOT NULL,
    discharge_date     date                        NOT NULL,
    discharge_time     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    discharge_notes    VARCHAR(255),
    patient_nas        VARCHAR(255)                NOT NULL,
    discharge_nurse_id VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_patient_discharge PRIMARY KEY (discharge_id)
);

ALTER TABLE IF EXISTS patient_discharge
    DROP CONSTRAINT IF EXISTS FK_PATIENT_DISCHARGE_ON_DISCHARGE_NURSE;

ALTER TABLE IF EXISTS patient_discharge
    ADD CONSTRAINT FK_PATIENT_DISCHARGE_ON_DISCHARGE_NURSE FOREIGN KEY (discharge_nurse_id) REFERENCES staff (staff_id);

ALTER TABLE IF EXISTS patient_discharge
    DROP CONSTRAINT IF EXISTS FK_PATIENT_DISCHARGE_ON_PATIENT_NAS;

ALTER TABLE IF EXISTS patient_discharge
    ADD CONSTRAINT FK_PATIENT_DISCHARGE_ON_PATIENT_NAS FOREIGN KEY (patient_nas) REFERENCES patient (nas);

CREATE TABLE IF NOT EXISTS administration_time
(
    administration_time_id UUID    NOT NULL,
    time_of_day            date    NOT NULL,
    unites_administered    INTEGER NOT NULL,
    prescription_id        UUID    NOT NULL,
    CONSTRAINT pk_administration_time PRIMARY KEY (administration_time_id)
);

CREATE TABLE IF NOT EXISTS medication_prescription
(
    prescription_id                  UUID         NOT NULL,
    drug_number                      BIGINT       NOT NULL,
    drug_name                        VARCHAR(255) NOT NULL,
    unite_by_day                     INTEGER      NOT NULL,
    number_of_administration_per_day INTEGER      NOT NULL,
    method_of_administration         VARCHAR(255) NOT NULL,
    start_date                       date         NOT NULL,
    end_date                         date         NOT NULL,
    patient_nas                      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_medication_prescription PRIMARY KEY (prescription_id)
);

ALTER TABLE IF EXISTS medication_prescription
    DROP CONSTRAINT IF EXISTS FK_MEDICATION_PRESCRIPTION_ON_PATIENT_NAS;

ALTER TABLE IF EXISTS medication_prescription
    ADD CONSTRAINT FK_MEDICATION_PRESCRIPTION_ON_PATIENT_NAS FOREIGN KEY (patient_nas) REFERENCES patient (nas);

ALTER TABLE IF EXISTS administration_time
    DROP CONSTRAINT IF EXISTS FK_ADMINISTRATION_TIME_ON_PRESCRIPTION;

ALTER TABLE IF EXISTS administration_time
    ADD CONSTRAINT FK_ADMINISTRATION_TIME_ON_PRESCRIPTION FOREIGN KEY (prescription_id) REFERENCES medication_prescription (prescription_id);


