package seg3x02.pms.contracts.testStubs.services

import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.common.DomainEvent
import seg3x02.pms.domain.patient.events.AddressCreatedEvent
import seg3x02.pms.domain.patient.events.PatientCreatedEvent

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class EventEmitterStub: DomainEventEmitter {
    private val events: MutableList<DomainEvent> = ArrayList()
    override fun emit(event: DomainEvent) {
        events.add(event)
    }

    fun retrieveAddressCreatedEvent(): AddressCreatedEvent {
        return events.find { it is AddressCreatedEvent} as AddressCreatedEvent
    }

    fun retrievePatientCreatedEvent(): PatientCreatedEvent {
        return events.find { it is PatientCreatedEvent} as PatientCreatedEvent
    }

    fun retrievePatientNextOfKinCreatedEvent(): PatientCreatedEvent {
        return events.find { it is PatientCreatedEvent} as PatientCreatedEvent
    }

    fun retrievePatientUpdatedEvent(): PatientCreatedEvent {
        return events.find { it is PatientCreatedEvent} as PatientCreatedEvent
    }
}