package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import seg3x02.pms.domain.staff.entities.Staff
import seg3x02.pms.domain.staff.enums.StaffRoleEnum
import seg3x02.pms.domain.user.entities.UserAccount
import seg3x02.pms.infrastructure.jpa.entities.staff.StaffJpaEntity
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/

@Mapper(uses = [MedicationPrescriptionJpaConverter::class], componentModel = "spring")
interface StaffJpaConverter {

/*            val staffId: String,
    val divisionId: UUID,
) {
    lateinit var user: UserAccount
    lateinit var role: StaffRoleEnum*/
        @Mapping(target = "staffId", source = "staffId")
        @Mapping(target = "user", source = "user")
        @Mapping(target = "division.id", source = "divisionId")
        @Mapping(target = "role", qualifiedByName = ["staffRoleToStaffRoleEnumInfra"])
        fun convertToJpaEntity(domain: Staff): StaffJpaEntity

        @Named("staffRoleToStaffRoleEnumInfra")
        fun staffRoleToStaffRoleEnum(staffRole: StaffRoleEnum): seg3x02.pms.infrastructure.jpa.enums.staff.StaffRoleEnum {
                return seg3x02.pms.infrastructure.jpa.enums.staff.StaffRoleEnum.valueOf(staffRole.name)
        }

        @Mapping(target = "staffId", source = "staffId")
        @Mapping(target = "user", source = "user")
        @Mapping(target = "divisionId", source = "division.id")
        @Mapping(target = "role", qualifiedByName = ["staffRoleEnumToStaffRoleDomain"])
        fun convertToModel(jpaEntity: StaffJpaEntity): Staff

        @Named("staffRoleEnumToStaffRoleDomain")
        fun staffRoleEnumToStaffRole(staffRoleEnum: seg3x02.pms.infrastructure.jpa.enums.staff.StaffRoleEnum): StaffRoleEnum {
                return StaffRoleEnum.valueOf(staffRoleEnum.name)
        }
}