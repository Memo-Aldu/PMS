package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import seg3x02.pms.application.dtos.queries.converters.MedicationPrescriptionDtoConverter
import seg3x02.pms.domain.prescription.entities.MedicationPrescription
import seg3x02.pms.domain.prescription.factory.MedicationPrescriptionFactory

@Primary
@Component
class MedicationPrescriptionDtoFactory: MedicationPrescriptionFactory {
    private val dtoConverter = Mappers.getMapper(MedicationPrescriptionDtoConverter::class.java)
    override fun createMedicationPrescription(prescriptionInfo: MedicationPrescriptionDto): MedicationPrescription {
        return dtoConverter.convertDto(prescriptionInfo)
    }
}