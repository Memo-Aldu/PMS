package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.PatientAdmissionJpaConverter
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.domain.patient.repositories.PatientAdmissionRepository
import seg3x02.pms.infrastructure.jpa.dao.PatientAdmissionJpaRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/

@Component
@CacheConfig(cacheNames = ["patientAdmission"])
class PatientAdmissionJpaAdapter(private val patientAdmissionRepository: PatientAdmissionJpaRepository): PatientAdmissionRepository {
    private val converter = Mappers.getMapper(PatientAdmissionJpaConverter::class.java)

    @Cacheable(key = "#id")
    override fun findById(id: UUID): PatientAdmission? {
        val patientAdmissionJpa = patientAdmissionRepository.findByIdOrNull(id)
        return patientAdmissionJpa?.let { converter.convertToModel(it) }
    }

    @Cacheable(key = "#nas")
    override fun findByPatientNAS(nas: String): PatientAdmission? {
        val patientAdmissionJpa = patientAdmissionRepository.findByPatientNAS(nas)
        return patientAdmissionJpa?.let { converter.convertToModel(it) }
    }

    @CachePut(key = "#patientAdmission.id")
    override fun save(patientAdmission: PatientAdmission): PatientAdmission {
        val patientAdmissionJpa = converter.convertToJpaEntity(patientAdmission)
        patientAdmissionRepository.save(patientAdmissionJpa)
        return patientAdmission
    }

}