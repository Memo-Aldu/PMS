package seg3x02.pms.domain.prescription.entities

import seg3x02.pms.domain.prescription.enums.PrescriptionAdministrationMethodEnum
import java.time.LocalDateTime
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-08, Wednesday
 **/
class MedicationPrescription(
    val id: UUID,
    val drugNumber: Long,
    val drugName: String,
    val uniteByDay: Int,
    val numberOfAdministrationPerDay: Int,
    val administrationTimes: MutableList<UUID> = ArrayList(),
    val methodOfAdministration: PrescriptionAdministrationMethodEnum,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
)