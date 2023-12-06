package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.PatientNextOfKinJpaConverter
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.repositories.PatientNextOfKinRepository
import seg3x02.pms.infrastructure.jpa.dao.PatientNextOfKinJpaRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Component
@CacheConfig(cacheNames = ["patientNextOfKin"])
class PatientNextOfKinJpaAdapter(private val patientNextOfKinRepository: PatientNextOfKinJpaRepository):
    PatientNextOfKinRepository {
    private val converter = Mappers.getMapper(PatientNextOfKinJpaConverter::class.java)

    @CachePut(key = "#patientNextOfKin.id")
    override fun save(patientNextOfKin: PatientNextOfKin): PatientNextOfKin {
        val patientNextOfKinJpa = converter.convertToJpaEntity(patientNextOfKin)
        patientNextOfKinRepository.save(patientNextOfKinJpa)
        return patientNextOfKin
    }

    @Cacheable(key = "#id")
    override fun findById(id: UUID): PatientNextOfKin? {
        val patientNextOfKinJpa = patientNextOfKinRepository.findByIdOrNull(id)
        return patientNextOfKinJpa?.let { converter.convertToModel(it) }
    }
}