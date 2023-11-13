package seg3x02.pms.domain.patient.events

import seg3x02.pms.domain.common.DomainEvent
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class PatientUpdatedEvent(
    val id: UUID,
    val occurredOn: Date,
    val patientId: String
) : DomainEvent