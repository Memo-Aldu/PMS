package seg3x02.pms.infrastructure.web.services

import org.springframework.stereotype.Service
import seg3x02.pms.infrastructure.web.forms.RegisterStaffForm
import java.security.Principal

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
@Service
class StaffService {
    fun registerStaff(registerStaffData: RegisterStaffForm) {

    }

    fun getCurrentStaffUsername(principal: Principal?): Any {
            TODO("Not yet implemented")
    }
}