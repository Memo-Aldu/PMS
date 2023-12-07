package seg3x02.pms.infrastructure.web.forms.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.StaffRegisterDto
import seg3x02.pms.infrastructure.web.forms.RegisterStaffForm

abstract class RegisterStaffFormDtoConverter {
    @Mappings(
        Mapping(target = "staffId", source = "userName"),
        Mapping(target = "password", source = "password"),
        Mapping(target = "firstName", source = "staffFirstname"),
        Mapping(target = "lastName", source = "staffLastname"),
        Mapping(target = "email", source = "email")
    )
    abstract fun convertToDto(registerStaffForm: RegisterStaffForm): StaffRegisterDto
}