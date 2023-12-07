package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import seg3x02.pms.application.dtos.queries.StaffRegisterDto
import seg3x02.pms.domain.staff.entities.Staff

@Mapper
interface StaffRegisterDtoConverter {

        fun convertDto(staff: Staff): StaffRegisterDto
        fun convertToDomain(dto: StaffRegisterDto): Staff
}