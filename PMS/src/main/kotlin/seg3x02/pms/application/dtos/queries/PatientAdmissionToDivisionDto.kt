package seg3x02.pms.application.dtos.queries

import java.util.UUID
/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class PatientAdmissionToDivisionDto(
        val patientNAS: String,
        val divisonId: UUID,
        val requestingChargedNurseNAS: String,
        val approvingChargedNurseNAS: String,
        val roomId: UUID,
        val bedId: UUID,
        val optionPrivateInsuranceNumber: String?,
)
