package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.enums.DivisionStatus
import seg3x02.pms.domain.staff.entities.Staff
import seg3x02.pms.infrastructure.jpa.entities.division.DivisionJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.staff.StaffJpaEntity
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/

@Mapper(uses = [StaffJpaConverter::class, RoomJpaConverter::class], componentModel = "spring")
interface DivisionJpaConverter {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "divisionName", source = "divisionName")
    @Mapping(target = "divisionStatus", qualifiedByName = ["divisionStatusDomainToDivisionStatusEnum"])
    fun convertToJpaEntity(domain: Division): DivisionJpaEntity

    @Mapping(target = "staffs", source = "staffs")
    @Mapping(target = "divisionStatus", qualifiedByName = ["divisionStatusEnumToDivisionStatusDomain"])
    @Mapping(target = "chargeNurse", source = "chargeNurse")
    @Mapping(target = "rooms", source = "rooms")
    fun convertToModel(jpaEntity: DivisionJpaEntity): Division


    @Named("divisionStatusDomainToDivisionStatusEnum")
    fun divisionStatusDomainToDivisionStatusEnum(divisionStatus: DivisionStatus): seg3x02.pms.infrastructure.jpa.enums.division.DivisionStatus {
        return seg3x02.pms.infrastructure.jpa.enums.division.DivisionStatus.valueOf(divisionStatus.name)
    }

    @Named("divisionStatusEnumToDivisionStatusDomain")
    fun divisionStatusEnumToDivisionStatus(divisionStatusEnum: seg3x02.pms.infrastructure.jpa.enums.division.DivisionStatus): DivisionStatus {
        return DivisionStatus.valueOf(divisionStatusEnum.name)
    }
}