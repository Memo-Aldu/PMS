package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.dtos.queries.PatientUpdateDto
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.factory.PatientFactory
import seg3x02.pms.application.dtos.queries.converters.PatientRegisterDtoConverter

@Primary
@Component
class PatientDtoFactory: PatientFactory {
    private val dtoConverter = Mappers.getMapper(PatientRegisterDtoConverter::class.java)


    override fun createPatient(patient: PatientRegisterDto): Patient {
        return dtoConverter.convertDto(patient)
    }

    override fun createPatient(patientEntity: Patient, patient: PatientUpdateDto): Patient {
        TODO("Not yet implemented")
    }
}