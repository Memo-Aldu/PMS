package seg3x02.pms.domain.staff.facade

import seg3x02.pms.domain.staff.entities.Staff

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface StaffFacade {
    fun getStaffById(id: String): String?
}