package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.division.factory.PatientAdmissionRequestFactory

@Primary
@Component
class PatientAdmissionRequestDtoFactory: PatientAdmissionRequestFactory {
    private val dtoConverter = Mappers.getMapper(PatientAdmissionRequestDtoConverter::class.java)
    override fun createPatientAdmissionRequest(patientAdmissionRequestDto: PatientAdmissionRequestDto): AdmissionRequest {
        return dtoConverter.convertDto(patientAdmissionRequestDto)
    }
}