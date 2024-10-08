package seg3x02.pms.domain.prescription.repository

import seg3x02.pms.domain.prescription.entities.MedicationPrescription
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
interface MedicationPrescriptionRepository {
    fun getMedicationById(id: UUID): MedicationPrescription?
    fun medicationExistsByDrugNumber(drugNumber: Long): Boolean
    fun save(medication: MedicationPrescription): MedicationPrescription
}