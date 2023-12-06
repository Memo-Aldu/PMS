package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin

@Mapper
interface PatientNextToKinRegisterDtoConverter {
    @Mappings(
    Mapping(target = "firstName",  ignore = true),
    Mapping(target = "lastName",  ignore = true),
    Mapping(target = "phoneNumber",  ignore = true),
    Mapping(target = "address", ignore = true),
    Mapping(target = "relationship",  ignore = true)
    )
    fun convertDto(dto: PatientNextOfKinRegisterDto): PatientNextOfKin
}