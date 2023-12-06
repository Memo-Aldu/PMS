package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.StaffRegisterDto
import seg3x02.pms.domain.staff.entities.Staff

@Mapper
interface StaffRegisterDtoConverter {
    @Mappings(
        Mapping(target = "staffId",ignore = true),
        Mapping(target = "password", ignore = true),
        Mapping(target = "firstName",ignore = true),
        Mapping(target = "lastName", ignore = true),
        Mapping(target = "role", ignore = true),
        Mapping(target = "email", ignore = true)
    )
    fun convertDto(dto: StaffRegisterDto): Staff
}