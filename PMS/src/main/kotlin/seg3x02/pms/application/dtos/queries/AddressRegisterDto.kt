package seg3x02.pms.application.dtos.queries

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class AddressRegisterDto(
        val street: String,
        val city: String,
        val country: String,
        val postalCode: String
)
