package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.DivisionJpaConverter
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.repositories.DivisionRepository
import seg3x02.pms.infrastructure.jpa.dao.DivisionJpaRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/

@Component
@CacheConfig(cacheNames = ["divisions"])
class DivisionJpaAdapter(private val divisionRepository: DivisionJpaRepository): DivisionRepository {
    private val converter = Mappers.getMapper(DivisionJpaConverter::class.java)

    @Cacheable(key = "#id")
    override fun findById(id: UUID): Division? {
        val divisionJpa = divisionRepository.findByIdOrNull(id)
        return divisionJpa?.let { converter.convertToModel(it) }
    }

    @CachePut(key = "#division.id")
    override fun save(division: Division): Division {
        val divisionJpa = converter.convertToJpaEntity(division)
        divisionRepository.save(divisionJpa)
        return division
    }
}