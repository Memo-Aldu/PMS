package seg3x02.pms.application.dtos.queries.converters

import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.AdministrationTimeDto
import seg3x02.pms.domain.prescription.entities.AdministrationTime
import seg3x02.pms.domain.prescription.entities.MedicationPrescription
import java.util.UUID

@Mapper(componentModel = "spring", uses = [AdministrationTimeDtoConverter::class])
interface MedicationPrescriptionDtoConverter {

    fun convertDto(medicationPrescription: MedicationPrescription): MedicationPrescriptionDto
    fun convertToDomain(dto: MedicationPrescriptionDto, id: UUID): MedicationPrescription

}