package seg3x02.pms.application.dtos.queries.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientAdmissionFormRequestDto
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.staff.entities.Staff
import java.util.*

@Mapper(componentModel = "spring")
interface PatientAdmissionDtoConverter {

        fun convertDto(patientAdmission: PatientAdmission): PatientAdmissionToDivisionDto
        fun convertToDomain(dto: PatientAdmissionToDivisionDto): PatientAdmission
        fun convertToDomain(dto: PatientAdmissionFormRequestDto, requestId: AdmissionRequest): PatientAdmission
}