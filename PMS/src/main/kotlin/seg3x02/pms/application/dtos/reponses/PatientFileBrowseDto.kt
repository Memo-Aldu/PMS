package seg3x02.pms.application.dtos.reponses

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.ExternalDoctorDto
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.application.enums.MaritalStatusEnum
import seg3x02.pms.application.enums.PatientKinRelationshipEnum
import seg3x02.pms.domain.patient.entities.patient.Patient
import java.sql.Date

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
data class PatientFileBrowseDto(
    var nas: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val dob: Date,
    val gender: String,
    val maritalStatus: MaritalStatusEnum,
    var externalDoctor: ExternalDoctorDto,
    var address: AddressRegisterDto,
    var nextOfKin: PatientNextOfKinRegisterDto
) {
    constructor(patient: Patient) : this(
            patient.nas,
            patient.firstName,
            patient.lastName,
            patient.phoneNumber,
            patient.dob,
            patient.gender,
            MaritalStatusEnum.valueOf(patient.maritalStatus.toString()),
            externalDoctor = ExternalDoctorDto(
                patient.externalDoctor.externalDoctorFirstName,
                patient.externalDoctor.externalDoctorLastName,
                patient.externalDoctor.externalDoctorPhoneNumber,
                patient.externalDoctor.externalDoctorEmail,
            ),
            address = seg3x02.pms.application.dtos.queries.AddressRegisterDto(
                patient.address.street,
                patient.address.city,
                patient.address.country,
                patient.address.postalCode,
            ),
            nextOfKin = seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto(
                patient.nextOfKin.firstName,
                patient.nextOfKin.lastName,
                patient.nextOfKin.phoneNumber,
                AddressRegisterDto(
                    patient.nextOfKin.address.street,
                    patient.nextOfKin.address.city,
                    patient.nextOfKin.address.country,
                    patient.nextOfKin.address.postalCode,
                ),
                PatientKinRelationshipEnum.valueOf(patient.nextOfKin.relationship.toString())))
}
