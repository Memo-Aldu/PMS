package seg3x02.pms.application.dtos.queries.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientDischargeDto
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge

@Mapper(componentModel = "spring")
interface PatientDischargeDtoConverter {

        fun convertDto(patientDischarge: PatientDischarge): PatientDischargeDto
        fun convertToDomain(dto: PatientDischargeDto): PatientDischarge
}