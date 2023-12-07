package seg3x02.pms.infrastructure.web.forms

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class RegisterStaffForm {
    @NotEmpty(message = "Username is required")
    var userName: String? = null

    @NotEmpty(message = "Password is required")
    var password: String? = null

    @NotEmpty(message = "Confirm Password is required")
    var passwordConf: String? = null

    @NotEmpty(message = "First Name is required")
    var staffFirstname: String? = null

    @NotEmpty(message = "Last Name is required")
    var staffLastname: String? = null

    @NotEmpty(message = "Email is required")
    val email: String? = null
}
