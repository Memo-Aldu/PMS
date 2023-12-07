package seg3x02.pms.domain.user.entities

import seg3x02.pms.domain.user.enums.UserRoleEnum

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-04, Saturday
 **/
class UserAccount(
        val nas: String,
        val password: String,
        val firstName: String,
        val lastName: String,
        val email: String) {
    lateinit var role: UserRoleEnum
}