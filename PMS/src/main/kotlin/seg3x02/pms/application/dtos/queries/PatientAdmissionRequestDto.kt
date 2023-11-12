package seg3x02.pms.application.dtos.queries

import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class PatientAdmissionRequestDto(
        val patientNAS: String,
        val rationaleForRequest: String,
        val priorityAssessment: Int, // 1-10
        val localRequestingChargedNurseNAS: String,
        val divisionId: UUID
)
