package seg3x02.pms.application.dtos.queries

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class StaffRegisterDto(
        val staffNAS: String,
        val password: String,
        val firstName: String,
        val lastName: String,
        val email: String,
)
