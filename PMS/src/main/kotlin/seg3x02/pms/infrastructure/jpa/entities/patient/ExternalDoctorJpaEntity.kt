package seg3x02.pms.infrastructure.jpa.entities.patient

import jakarta.persistence.Embeddable
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
@Embeddable
class ExternalDoctorJpaEntity(
    var externalDoctorFirstName: String,
    var externalDoctorLastName: String,
    var externalDoctorPhoneNumber: String,
    var externalDoctorEmail: String,
)