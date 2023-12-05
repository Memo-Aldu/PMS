package seg3x02.pms.infrastructure.web.forms

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import java.util.UUID

class RequestPatientAdmissionForm {
    @NotEmpty(message = "Patient NAS is required")
    var patientNAS: String? = null

    @NotNull(message = "Rationale for Request is required")
    var rationaleForRequest: String? = null

    @NotNull(message = "Priority Assessment is required")
    var priorityAssessment: Int? = null

    @NotEmpty(message = "Local Requesting Charged Nurse NAS is required")
    var localRequestingChargedNurseNAS: String? = null

    @NotNull(message = "Division ID is required")
    var divisionId: UUID? = null
}
