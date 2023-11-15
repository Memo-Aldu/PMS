package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.staff.entities.Staff
import seg3x02.pms.domain.staff.repository.StaffRepository
import java.util.*
import kotlin.collections.HashMap

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class StaffRepositoryStub: StaffRepository {
    private val staff: MutableMap<String, Staff> = HashMap()
    override fun getStaffById(id: String): Staff? {
        return staff[id]
    }

    override fun save(staff: Staff): Staff {
        this.staff[staff.staffId] = staff
        return staff
    }
}