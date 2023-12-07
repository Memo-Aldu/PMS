package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.PatientAdmissionFormRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.dtos.queries.converters.PatientAdmissionDtoConverter
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.domain.patient.factory.PatientAdmissionFactory

@Primary
@Component
class PatientAdmissionDtoFactory: PatientAdmissionFactory {
    private val dtoConverter = Mappers.getMapper(PatientAdmissionDtoConverter::class.java)
    override fun createPatientAdmission(patientAdmissionToDivisionDto: PatientAdmissionToDivisionDto): PatientAdmission {
        return dtoConverter.convertToDomain(patientAdmissionToDivisionDto)
    }

    override fun createPatientAdmission(
        patientAdmissionFormRequestDto: PatientAdmissionFormRequestDto,
        request: AdmissionRequest
    ): PatientAdmission {
        return dtoConverter.convertToDomain(patientAdmissionFormRequestDto, request)
    }
}