package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.StaffJpaConverter
import seg3x02.pms.domain.staff.entities.Staff
import seg3x02.pms.domain.staff.repository.StaffRepository
import seg3x02.pms.infrastructure.jpa.dao.StaffJpaRepository

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/

@Component
@CacheConfig(cacheNames = ["staffs"])
class StaffJpaAdapter(private val staffRepository: StaffJpaRepository): StaffRepository {
    private val converter = Mappers.getMapper(StaffJpaConverter::class.java)

    @Cacheable(key = "#id")
    override fun getStaffById(id: String): Staff? {
        val staffJpa = staffRepository.findByIdOrNull(id)
        return staffJpa?.let { converter.convertToModel(it) }
    }

    @CachePut(key = "#staff.staffId")
    override fun save(staff: Staff): Staff {
        val staffJpa = converter.convertToJpaEntity(staff)
        staffRepository.save(staffJpa)
        return staff
    }
}