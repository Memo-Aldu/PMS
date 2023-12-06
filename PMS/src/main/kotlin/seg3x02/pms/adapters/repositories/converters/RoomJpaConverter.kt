package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.enums.RoomStatus
import seg3x02.pms.infrastructure.jpa.entities.division.RoomJpaEntity
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Mapper(componentModel = "spring", uses = [BedJpaConverter::class])
interface RoomJpaConverter {

        @Mapping(target = "id", source = "id")
        @Mapping(target = "roomStatus", qualifiedByName = ["roomStatusDomainToRoomStatusEnum"])
        @Mapping(target = "beds", source = "beds")
        @Mapping(target = "division", ignore = true)
        fun convertToJpaEntity(domain: Room): RoomJpaEntity

        @Mapping(target = "id", source = "id")
        @Mapping(target = "roomStatus", qualifiedByName = ["roomStatusEnumToRoomStatusDomain"])
        @Mapping(target = "beds", source = "beds")
        fun convertToModel(jpaEntity: RoomJpaEntity): Room

        @Named("roomStatusDomainToRoomStatusEnum")
        fun roomStatusDomainToRoomStatusEnum(roomStatus: seg3x02.pms.domain.division.enums.RoomStatus): seg3x02.pms.infrastructure.jpa.enums.division.RoomStatus {
                return seg3x02.pms.infrastructure.jpa.enums.division.RoomStatus.valueOf(roomStatus.name)
        }

        @Named("roomStatusEnumToRoomStatusDomain")
        fun roomStatusEnumToRoomStatus(roomStatusEnum: seg3x02.pms.infrastructure.jpa.enums.division.RoomStatus): seg3x02.pms.domain.division.enums.RoomStatus {
                return seg3x02.pms.domain.division.enums.RoomStatus.valueOf(roomStatusEnum.name)
        }
}