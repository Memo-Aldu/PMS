package seg3x02.pms.domain.prescription.entities

import java.time.LocalDateTime
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-08, Wednesday
 **/
class AdministrationTime(
    val administrationTimeID: UUID,
    val timeOfDay: LocalDateTime,
    val unitesAdministered: Int,
) {
}