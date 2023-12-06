package seg3x02.pms.adapters.factories
import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.converters.AddressDtoConverter
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.factory.AddressFactory

@Primary
@Component
class AddressDtoFactory: AddressFactory {
    private val dtoConverter = Mappers.getMapper(AddressDtoConverter::class.java)
    override fun createAddress(address: AddressRegisterDto): Address {
        return dtoConverter.convertDto(address)
    }
}