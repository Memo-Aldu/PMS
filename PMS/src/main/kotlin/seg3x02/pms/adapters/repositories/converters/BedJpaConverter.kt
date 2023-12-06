package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.infrastructure.jpa.entities.division.BedJpaEntity
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Mapper(componentModel = "spring")
interface BedJpaConverter {

    fun convertToJpaEntity(bed: Bed): BedJpaEntity
    fun convertToModel(bedJpaEntity: BedJpaEntity): Bed
}