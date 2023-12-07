package seg3x02.pms.application.dtos.queries.converters
import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.AdministrationTimeDto
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.prescription.entities.AdministrationTime
import seg3x02.pms.domain.prescription.entities.MedicationPrescription

@Mapper
interface AddressDtoConverter {

    @Mappings(
        Mapping(target = "street", ignore = true),
        Mapping(target = "city", ignore = true),
        Mapping(target = "country", ignore = true),
        Mapping(target = "postalCode", ignore = true)
    )
    fun convertDto(dto: AddressRegisterDto): Address
}