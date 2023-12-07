package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.BedJpaConverter
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.repositories.BedRepository
import seg3x02.pms.infrastructure.jpa.dao.BedJpaRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Component
@CacheConfig(cacheNames = ["beds"])
class BedJpaAdapter(private val bedRepository: BedJpaRepository): BedRepository {
    private val converter = Mappers.getMapper(BedJpaConverter::class.java)

    @Cacheable(key = "#id")
    override fun findById(id: UUID): Bed? {
        val bedJpa = bedRepository.findByIdOrNull(id)
        return bedJpa?.let { converter.convertToModel(it) }
    }

    @CachePut(key = "#bed.id")
    override fun save(bed: Bed): Bed {
        val bedJpa = converter.convertToJpaEntity(bed)
        bedRepository.save(bedJpa)
        return bed
    }
}