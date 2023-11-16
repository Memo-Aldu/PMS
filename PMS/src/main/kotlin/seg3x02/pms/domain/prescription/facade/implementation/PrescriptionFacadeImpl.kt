package seg3x02.pms.domain.prescription.facade.implementation

import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.prescription.facade.PrescriptionFacade
import seg3x02.pms.domain.prescription.factory.MedicationPrescriptionFactory
import seg3x02.pms.domain.prescription.repository.MedicationPrescriptionRepository
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class PrescriptionFacadeImpl(
    private val prescriptionRepository: MedicationPrescriptionRepository,
    private val prescriptionFactory: MedicationPrescriptionFactory,
    private var eventEmitter: DomainEventEmitter

    ): PrescriptionFacade {
    override fun medicationExistsByDrugNumber(drugNumber: Long): Boolean {
        return prescriptionRepository.medicationExistsByDrugNumber(drugNumber)
    }

    override fun prescribeMedication(prescription: MedicationPrescriptionDto): UUID {
      // Ensure the patient and the doctor exists before proceeding
        val patient: Patient
        if (patientFacade.patientExists(prescriptionDto.patientNAS)) {
            patient = patientFacade.getPatientByNAS(prescriptionDto.patientNAS)
        } else {
            throw IllegalArgumentException("Patient does not exist")
            }

        val doctor: Staff
        if (patientFacade.staffExists(prescriptionDto.prescribingDoctorId)) {
            doctor = patientFacade.getStaffById(prescriptionDto.prescribingDoctorId)
        } else {
            throw IllegalArgumentException("Doctor does not exist")
                }

        // Create medication prescription
        val prescription = prescriptionFactory.createMedicationPrescription(prescriptionDto).apply {
            setPatient(patient)
            setDoctor(doctor)
        }

        // Save the prescription
        val savedPrescription = prescriptionRepository.save(prescription)

        // Add the prescription to the patient's list of prescriptions
        patient.addPrescription(savedPrescription.id)

        // Emit an event to signal that the prescription has been created
        eventEmitter.emit(PrescriptionCreatedEvent(savedPrescription.id))

        return savedPrescription.id
    }

    // Helper methods to fetch patient and staff
    private fun getPatientByNAS(patientNAS: String): Patient? {
        return patientFacade.patientExists(patientNAS).let { exists ->
            if (exists) patientFacade.getPatientByNAS(patientNAS) else null
        }
    }

    private fun getStaffById(staffId: String): Staff? {
        // Assuming there's a method to fetch staff by ID in the patient facade
        return patientFacade.getStaffById(staffId)
    }

    // Assuming existence of PrescriptionCreatedEvent class
    private data class PrescriptionCreatedEvent(val prescriptionId: UUID) : DomainEvent

}