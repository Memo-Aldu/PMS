package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.domain.division.entities.AdmissionRequest

@Mapper
interface PatientAdmissionRequestDtoConverter {

    @Mappings(
        Mapping(target = "patientNAS", ignore = true),
        Mapping(target = "rationaleForRequest", ignore = true),
        Mapping(target = "priorityAssessment", ignore = true),
        Mapping(target = "localRequestingChargedNurseNAS", ignore = true),
        Mapping(target = "divisionId", ignore = true)
    )
    fun convertDto(dto: PatientAdmissionRequestDto): AdmissionRequest
}