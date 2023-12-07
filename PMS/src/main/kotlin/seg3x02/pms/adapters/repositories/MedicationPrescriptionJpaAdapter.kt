package seg3x02.pms.adapters.repositories

import org.mapstruct.factory.Mappers
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import seg3x02.pms.adapters.repositories.converters.MedicationPrescriptionJpaConverter
import seg3x02.pms.domain.prescription.entities.MedicationPrescription
import seg3x02.pms.domain.prescription.repository.MedicationPrescriptionRepository
import seg3x02.pms.infrastructure.jpa.dao.MedicationPrescriptionJpaRepository
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Component
@CacheConfig(cacheNames = ["prescriptions"])
class MedicationPrescriptionJpaAdapter(
    private val medicationPrescriptionRepository: MedicationPrescriptionJpaRepository):
    MedicationPrescriptionRepository {
    private val converter = Mappers.getMapper(MedicationPrescriptionJpaConverter::class.java)
    @Cacheable(key = "#id")
    override fun getMedicationById(id: UUID): MedicationPrescription? {
        val medicationPrescriptionJpa = medicationPrescriptionRepository.findByIdOrNull(id)
        return medicationPrescriptionJpa?.let { converter.convertToModel(it) }
    }

    @Cacheable(key = "#drugNumber")
    override fun medicationExistsByDrugNumber(drugNumber: Long): Boolean {
        return medicationPrescriptionRepository.existsByDrugNumber(drugNumber)
    }

    @CachePut(key = "#medication.id")
    override fun save(medication: MedicationPrescription): MedicationPrescription {
        val medicationPrescriptionJpa = converter.convertToJpaEntity(medication)
        medicationPrescriptionRepository.save(medicationPrescriptionJpa)
        return medication
    }
}