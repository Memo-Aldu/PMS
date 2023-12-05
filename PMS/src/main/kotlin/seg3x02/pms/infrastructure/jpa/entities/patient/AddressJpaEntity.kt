package seg3x02.pms.infrastructure.jpa.entities.patient

import jakarta.persistence.Embeddable

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
@Embeddable
class AddressJpaEntity(
        var street: String,
        var city: String,
        var country: String,
        var postalCode: String
)