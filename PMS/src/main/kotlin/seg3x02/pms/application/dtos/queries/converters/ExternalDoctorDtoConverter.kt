package seg3x02.pms.application.dtos.queries.converters
import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.AdministrationTimeDto
import seg3x02.pms.application.dtos.queries.ExternalDoctorDto
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.prescription.entities.AdministrationTime
import seg3x02.pms.domain.prescription.entities.MedicationPrescription

@Mapper(componentModel = "spring")
interface ExternalDoctorDtoConverter {

        fun convertDto(externalDoctor: ExternalDoctor): ExternalDoctorDto
        fun convertToDomain(dto: ExternalDoctorDto): ExternalDoctor
}