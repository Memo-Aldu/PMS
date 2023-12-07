package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.ExternalDoctorDto
import seg3x02.pms.application.dtos.queries.converters.ExternalDoctorDtoConverter
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.factory.ExternalDoctorFactory

@Primary
@Component
class ExternalDoctorDtoFactory: ExternalDoctorFactory {
    private val dtoConverter = Mappers.getMapper(ExternalDoctorDtoConverter::class.java)
    override fun createExternalDoctor(externalDoctor: ExternalDoctorDto): ExternalDoctor {
        return dtoConverter.convertDto(externalDoctor)
    }
}
