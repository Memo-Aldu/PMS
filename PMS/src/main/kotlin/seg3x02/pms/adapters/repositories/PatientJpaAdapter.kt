package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.PatientJpaConverter
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.repositories.PatientRepository
import seg3x02.pms.infrastructure.jpa.dao.PatientJpaRepository

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Component
@CacheConfig(cacheNames = ["patient"])
class PatientJpaAdapter(private val patientRepository: PatientJpaRepository): PatientRepository {
    private val converter = Mappers.getMapper(PatientJpaConverter::class.java)

    @Cacheable(key = "#nas")
    override fun findById(nas: String): Patient? {
        val patientJpa = patientRepository.findByIdOrNull(nas)
        return patientJpa?.let { converter.convertToModel(it) }
    }

    @CachePut(key = "#patient.nas")
    override fun save(patient: Patient): Patient {
        val patientJpa = converter.convertToJpaEntity(patient)
        patientRepository.save(patientJpa)
        return patient
    }
}