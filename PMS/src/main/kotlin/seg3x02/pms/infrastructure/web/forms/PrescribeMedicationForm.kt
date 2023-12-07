package seg3x02.pms.infrastructure.web.forms

import seg3x02.pms.application.enums.PrescriptionAdministrationMethodEnum
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.Min
import javax.validation.constraints.Max

class PrescribeMedicationForm {
    @NotEmpty(message = "Patient NAS is required")
    var patientNAS: String? = null

    @NotEmpty(message = "Prescribing Doctor ID is required")
    var prescribingDoctorId: String? = null

    @Positive(message = "Drug Number must be a positive value")
    var drugNumber: Long? = null

    @NotEmpty(message = "Drug Name is required")
    var drugName: String? = null

    @Min(value = 1, message = "Units by Day must be at least 1")
    var unitsByDay: Int? = null

    @Min(value = 1, message = "Number of Administration Per Day must be at least 1")
    var numberOfAdministrationPerDay: Int? = null

    @NotEmpty(message = "Administration Times are required")
    var administrationTimes: List<AdministrationTimeForm>? = null

    @NotNull(message = "Method of Administration is required")
    var methodOfAdministration: PrescriptionAdministrationMethodEnum? = null

    @NotNull(message = "Start Date is required")
    var startDate: LocalDateTime? = null

    @NotNull(message = "End Date is required")
    var endDate: LocalDateTime? = null
}
