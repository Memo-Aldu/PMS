package seg3x02.pms.domain.staff.facade.implementation

import seg3x02.pms.domain.staff.entities.Staff
import seg3x02.pms.domain.staff.facade.StaffFacade
import seg3x02.pms.domain.staff.repository.StaffRepository

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class StaffFacadeImpl(
    private val staffRepository: StaffRepository
) : StaffFacade {
    override fun getStaffById(id: String): String? {
        return staffRepository.getStaffById(id)?.staffId
    }
}