package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import seg3x02.pms.adapters.repositories.converters.AdmissionRequestJpaConverter
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.division.repositories.PatientAdmissionRequestRepository
import seg3x02.pms.infrastructure.jpa.dao.AdmissionRequestJpaRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Component
@CacheConfig(cacheNames = ["admissionRequest"])
class AdmissionRequestJpaAdapter(
    private val admissionRequestRepository: AdmissionRequestJpaRepository): PatientAdmissionRequestRepository {
    private val converter = Mappers.getMapper(AdmissionRequestJpaConverter::class.java)
    @Cacheable(key = "#id")
    @Transactional
    override fun findById(id: UUID): AdmissionRequest? {
        val admissionRequestJpa = admissionRequestRepository.findByIdOrNull(id)
        return admissionRequestJpa?.let { converter.convertToModel(it) }
    }

    @CachePut(key = "#admissionRequest.id")
    override fun save(admissionRequest: AdmissionRequest): AdmissionRequest {
        val admissionRequestJpa = converter.convertToJpaEntity(admissionRequest)
        admissionRequestRepository.save(admissionRequestJpa)
        return admissionRequest
    }
}