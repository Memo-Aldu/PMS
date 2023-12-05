package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.PatientDischargeDto
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge
import seg3x02.pms.domain.patient.factory.PatientDischargeFactory

@Primary
@Component
class PatientDischargedDtoFactory: PatientDischargeFactory {
    private val dtoConverter = Mappers.getMapper(PatientDischargeDtoConverter::class.java)
    override fun createPatientDischarge(patientDischargeDto: PatientDischargeDto): PatientDischarge {
        return dtoConverter.convertDto(patientDischargeDto)
    }
}