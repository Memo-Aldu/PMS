package seg3x02.pms.domain.division.entities

import seg3x02.pms.domain.division.enums.RationalOfRequestEnum
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.staff.entities.Staff
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
class AdmissionRequest(
    val id: UUID,
    val divisionId: UUID,
    val rationaleForRequest: String,
    val priorityAssessment: RationalOfRequestEnum,
    var requestingChargedNurse: Staff? = null,
    var patient: Patient? = null
) {

}