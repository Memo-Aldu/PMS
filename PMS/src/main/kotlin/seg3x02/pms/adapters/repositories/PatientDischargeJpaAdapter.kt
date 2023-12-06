package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.PatientDischargeJpaConverter
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge
import seg3x02.pms.domain.patient.repositories.PatientDischargeRepository
import seg3x02.pms.infrastructure.jpa.dao.PatientDischargeJpaRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Component
@CacheConfig(cacheNames = ["patientDischarge"])
class PatientDischargeJpaAdapter(
    private val patientDischargeRepository: PatientDischargeJpaRepository): PatientDischargeRepository {
    private val converter = Mappers.getMapper(PatientDischargeJpaConverter::class.java)

    @CachePut(key = "#patientDischarge.id")
    override fun save(patientDischarge: PatientDischarge): PatientDischarge {
        val patientDischargeJpa = converter.convertToJpaEntity(patientDischarge)
        patientDischargeRepository.save(patientDischargeJpa)
        return patientDischarge
    }

    @Cacheable(key = "#id")
    override fun findById(id: UUID): PatientDischarge? {
        val patientDischargeJpa = patientDischargeRepository.findByIdOrNull(id)
        return patientDischargeJpa?.let { converter.convertToModel(it) }
    }
}