package seg3x02.pms.domain.staff.entities

import seg3x02.pms.domain.user.entities.UserAccount
import seg3x02.pms.domain.user.entities.UserRole

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-08, Wednesday
 **/
class Staff(
    val staffId: String,
    // division: Division,


) {
    lateinit var user: UserAccount
    lateinit var role: UserRole
}