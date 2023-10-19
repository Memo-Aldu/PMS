package seg3x02.pms.application.dtos.queries

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class PatientAdmissionToDivisionDto(
        val patientNAS: String,
        val chargeNurseNAS: String,
        val localDoctorNAS: String,
        val roomNumber: Int,
        val bedNumber: Int,
        val optionPrivateInsuranceNumber: String?,
)
