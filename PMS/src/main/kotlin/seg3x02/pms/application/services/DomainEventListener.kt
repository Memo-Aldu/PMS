package seg3x02.pms.application.services
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

interface DomainEventListener {
    @Async
    @EventListener
    fun handleAddressCreatedEvent(event: AddressCreatedEvent)

    @Async
    @EventListener
    fun handleDischargeCreatedEvent(event: DischargeCreatedEvent)

    @Async
    @EventListener
    fun handlePatientCreatedEvent(event: PatientCreatedEvent)

    @Async
    @EventListener
    fun handlePatientNextOfKinCreatedEvent(event: PatientNextOfKinCreatedEvent)

    @Async
    @EventListener
    fun handlePatientUpdatedEvent(event: PatientUpdatedEvent)

    @Async
    @EventListener
    fun handlePatientAdmissionCreatedEvent(event: PatientAdmissionCreatedEvent)

    @Async
    @EventListener
    fun handlePatientRequestAdmissionCreatedEvent(event: PatientRequestAdmissionCreatedEvent)

    @Async
    @EventListener
    fun handlePrescriptionCreatedEvent(event: PrescriptionCreatedEvent)

}