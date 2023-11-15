package seg3x02.pms.domain.prescription.facade

import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
interface PrescriptionFacade {
    fun medicationExistsByDrugNumber(drugNumber: Long): Boolean
    fun prescribeMedication(prescription: MedicationPrescriptionDto): UUID

}