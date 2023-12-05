package seg3x02.pms.domain.division.events

import seg3x02.pms.domain.common.DomainEvent
import java.util.*
class PatientRequestAdmissionCreatedEvent(
    val id: UUID,
    val occurredOn: Date,
    val patientNAS: String
) : DomainEvent