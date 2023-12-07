package seg3x02.pms.application.dtos.queries.converters
import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientUpdateDto
import seg3x02.pms.domain.patient.entities.patient.Patient

@Mapper(componentModel = "spring")
interface PatientUpdateDtoConverter {

        fun convertDto(patient: Patient): PatientUpdateDto
        fun convertToDomain(dto: PatientUpdateDto): Patient
}