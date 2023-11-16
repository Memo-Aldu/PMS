package seg3x02.pms.domain.prescription.facade.implementation

import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.prescription.events.PrescriptionCreatedEvent
import seg3x02.pms.domain.prescription.facade.PrescriptionFacade
import seg3x02.pms.domain.prescription.factory.MedicationPrescriptionFactory
import seg3x02.pms.domain.prescription.repository.MedicationPrescriptionRepository
import java.util.*

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
        val medication = prescriptionFactory.createMedicationPrescription(prescription)
        prescriptionRepository.save(medication)
        eventEmitter.emit(PrescriptionCreatedEvent(
            UUID.randomUUID(),
            Date(),
            prescription.patientNAS,
        ))
        return medication.id
    }

}