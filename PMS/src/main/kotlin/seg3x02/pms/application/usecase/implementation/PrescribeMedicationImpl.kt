package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import seg3x02.pms.application.usecase.PrescribeMedication
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.prescription.facade.PrescriptionFacade
import seg3x02.pms.domain.staff.facade.StaffFacade

/**
 * @author : Ahmed ghadbawi
 * @mailto : aghad014@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class PrescribeMedicationImpl(
    private val prescriptionFacade: PrescriptionFacade,
    private val patientFacade: PatientFacade,
    private val staffFacade: StaffFacade
): PrescribeMedication {
    override fun prescribeMedication(prescription: MedicationPrescriptionDto): Boolean {
        val patientExists = patientFacade.patientExists(prescription.patientNAS) // already defined in concrete class
        val medicationExists = prescriptionFacade.medicationExistsByDrugNumber(prescription.drugNumber) // already defined in concrete class
        val doctorID = staffFacade.getStaffById(prescription.prescribingDoctorId) // already defined in concrete class
        // check if the patient exists, if the medication exists and if the doctor exists
        if (patientExists && medicationExists && doctorID != null) {
            val prescriptionID = prescriptionFacade.prescribeMedication(prescription) // this methode needs to check if the medication is already prescribed to the patient
            //  add the prescription to the patient's list of prescriptions and return true
            patientFacade.addPrescriptionToPatient(prescription.patientNAS, prescriptionID)
            return true
        }
        return false
    }
}