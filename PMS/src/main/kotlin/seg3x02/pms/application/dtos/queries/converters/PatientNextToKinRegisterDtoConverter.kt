package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin

@Mapper(componentModel = "spring")
interface PatientNextToKinRegisterDtoConverter {

        fun convertDto(patientNextOfKin: PatientNextOfKin): PatientNextOfKinRegisterDto
        fun convertToDomain(dto: PatientNextOfKinRegisterDto): PatientNextOfKin
}