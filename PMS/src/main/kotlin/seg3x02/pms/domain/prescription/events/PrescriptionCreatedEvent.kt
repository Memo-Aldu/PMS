package seg3x02.pms.domain.prescription.events
import seg3x02.pms.domain.common.DomainEvent
import java.util.*

 
class PrescriptionCreatedEvent( 
  val id: UUID,
  val occurredOn: Date,
  val patientNAS: String
) : DomainEvent