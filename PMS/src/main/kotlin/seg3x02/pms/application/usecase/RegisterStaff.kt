package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.queries.StaffRegisterDto

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
interface RegisterStaff {

    /**
     * Register a staff member to the system (UC9)
     * @param staff StaffRegisterDto
     * @return String? staff ID if staff was registered, null otherwise
     */
    fun registerStaff(staff: StaffRegisterDto) : String?
}