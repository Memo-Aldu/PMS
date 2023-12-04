package seg3x02.pms.application.dtos.queries

import seg3x02.pms.application.enums.MaritalStatusEnum
import java.sql.Date

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class PatientRegisterDto(
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
)
