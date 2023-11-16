package seg3x02.pms.domain.prescription.factory

import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import seg3x02.pms.domain.prescription.entities.MedicationPrescription

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
**/

interface MedicationPrescriptionFactory {
    fun createMedicationPrescription(prescriptionInfo: MedicationPrescriptionDto): MedicationPrescription

}