package seg3x02.pms.domain.staff.entities

import seg3x02.pms.domain.user.entities.UserAccount
import seg3x02.pms.domain.user.entities.UserRole
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-08, Wednesday
 **/
class Staff(
    val staffId: String,
    val divisionId: UUID,
) {
    lateinit var user: UserAccount
    lateinit var role: UserRole
}