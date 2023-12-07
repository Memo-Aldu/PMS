package seg3x02.pms.application.dtos.queries

import seg3x02.pms.application.enums.PrescriptionAdministrationMethodEnum
import java.time.LocalDateTime

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class MedicationPrescriptionDto(
    val patientNAS: String,
    val prescribingDoctorId: String,
    val drugNumber: Long,
    val drugName: String,
    val unitsByDay: Int,
    val numberOfAdministrationPerDay: Int,
    val administrationTimes: List<AdministrationTimeDto>,
    val methodOfAdministration: PrescriptionAdministrationMethodEnum,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
)

data class AdministrationTimeDto(
        val timeOfDay: LocalDateTime,
        val unitsAdministered: Int
)