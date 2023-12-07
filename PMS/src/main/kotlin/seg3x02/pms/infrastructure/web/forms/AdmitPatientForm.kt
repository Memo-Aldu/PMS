package seg3x02.pms.infrastructure.web.forms
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import java.util.UUID

class AdmitPatientForm {
    @NotEmpty(message = "Patient NAS is required")
    var patientNAS: String? = null

    @NotNull(message = "Division ID is required")
    var divisionId: UUID? = null

    @NotEmpty(message = "Requesting Charged Nurse NAS is required")
    var requestingChargedNurseNAS: String? = null

    @NotEmpty(message = "Approving Charged Nurse NAS is required")
    var approvingChargedNurseNAS: String? = null

    @NotNull(message = "Room ID is required")
    var roomId: UUID? = null

    @NotNull(message = "Bed ID is required")
    var bedId: UUID? = null

    var optionPrivateInsuranceNumber: String? = null
}