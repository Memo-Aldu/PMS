package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.factory.PatientNextOfKinFactory

@Primary
@Component
class PatientNextOfKinDtoFactory: PatientNextOfKinFactory {
    private val dtoConverter = Mappers.getMapper(PatientNextOfKinRegisterDtoConverter::class.java)

    override fun createPatientNextOfKin(patientNextOfKin: PatientNextOfKinRegisterDto): PatientNextOfKin {
        return dtoConverter.convertDto(patientNextOfKin)
    }
}