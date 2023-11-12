package seg3x02.pms.domain.patient.entities.patient

import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
class Address(
        val id: UUID,
        val street: String,
        val city: String,
        val country: String,
        val postalCode: String
) {
}