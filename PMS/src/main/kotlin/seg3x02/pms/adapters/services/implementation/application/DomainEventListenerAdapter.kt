package seg3x02.pms.adapters.services.implementation.application
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import seg3x02.pms.domain.patient.events.DischargeCreatedEvent
import seg3x02.pms.domain.patient.events.AddressCreatedEvent
import seg3x02.pms.domain.patient.events.PatientAdmissionCreatedEvent
import seg3x02.pms.domain.patient.events.PatientCreatedEvent
import seg3x02.pms.domain.patient.events.PatientUpdatedEvent
import seg3x02.pms.domain.patient.events.PatientNextOfKinCreatedEvent
import seg3x02.pms.domain.division.events.PatientRequestAdmissionCreatedEvent
import seg3x02.pms.domain.prescription.events.PrescriptionCreatedEvent
import java.sql.Date
import java.text.DateFormat

@Component
class DomainEventListenerAdapter {
    @Async
    @EventListener
    fun handleAddressCreatedEvent(event: AddressCreatedEvent) {
        println(event.occurredOn.toString() + "Address was added:" + event.addressId)
    }

    @Async
    @EventListener
    fun handleDischargeCreatedEvent(event: DischargeCreatedEvent) {
        println(event.occurredOn.toString() + "Discharge was added:" + event.id)
    }

    @Async
    @EventListener
    fun handlePatientCreatedEvent(event: PatientCreatedEvent) {
        println(event.occurredOn.toString() + "Patient was added:" + event.patientNAS)
    }

    @Async
    @EventListener
    fun handlePatientNextOfKinCreatedEvent(event: PatientNextOfKinCreatedEvent) {
        println(event.occurredOn.toString() + "Patient Next Of Kin was added:" + event.nextOfKinId)
    }

    @Async
    @EventListener
    fun handlePatientUpdatedEvent(event: PatientUpdatedEvent) {
        println(event.occurredOn.toString() + "Patient was updated:" + event.patientId)
    }

    @Async
    @EventListener
    fun handlePatientAdmissionCreatedEvent(event: PatientAdmissionCreatedEvent) {
        println(event.occurredOn.toString() + "Patient Admission was added:" + event.patientNAS)
    }

    @Async
    @EventListener
    fun handlePatientRequestAdmissionCreatedEvent(event: PatientRequestAdmissionCreatedEvent) {
        println(event.occurredOn.toString() + "Patient Request Admission was added:" + event.patientNAS)
    }

    @Async
    @EventListener
    fun handlePrescriptionCreatedEvent(event: PrescriptionCreatedEvent) {
        println(event.occurredOn.toString() + "Prescription was added for:" + event.patientNAS)
    }

}