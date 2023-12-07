package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.domain.patient.entities.patient.Patient

@Mapper(componentModel = "spring")
interface PatientRegisterDtoConverter {

    fun convertDto(patient: Patient): PatientRegisterDto
    fun convertToDomain(dto: PatientRegisterDto): Patient
}