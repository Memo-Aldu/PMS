package seg3x02.pms.domain.patient.entities.patient

import seg3x02.pms.domain.patient.enums.MaritalStatusEnum
import java.sql.Date

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
class Patient(
    val nas: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val dob: Date,
    val gender: String,
    val maritalStatus: MaritalStatusEnum,
) {
    lateinit var address: Address;
    lateinit var nextOfKin: PatientNextOfKin;
    lateinit var externalDoctor: ExternalDoctor;

}