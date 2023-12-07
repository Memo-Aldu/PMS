package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.domain.patient.entities.patient.Address

@Mapper(componentModel = "spring")
interface AddressDtoConverter {

    fun convertToDto(address: Address): AddressRegisterDto
    fun convertToDomain(dto: AddressRegisterDto): Address
}