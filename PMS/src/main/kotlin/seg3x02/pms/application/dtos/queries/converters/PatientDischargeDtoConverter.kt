package seg3x02.pms.application.dtos.queries.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientDischargeDto
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge

@Mapper
interface PatientDischargeDtoConverter {
    @Mappings(
        Mapping(target = "patientNAS",  ignore = true),
        Mapping(target = "dischargeReason", ignore = true),
        Mapping(target = "dischargeDate",  ignore = true),
        Mapping(target = "dischargeTime", ignore = true),
        Mapping(target = "dischargeNurseNAS",  ignore = true),
        Mapping(target = "dischargeNotes",  ignore = true)
    )
    fun convertDto(dto: PatientDischargeDto): PatientDischarge
}