package seg3x02.pms.application.dtos.queries.converters

import org.mapstruct.Mapper
import seg3x02.pms.application.dtos.queries.AdministrationTimeDto
import seg3x02.pms.domain.prescription.entities.AdministrationTime
import java.time.LocalDateTime
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
@Mapper(componentModel = "spring")
interface AdministrationTimeDtoConverter {
    fun convertToDomain(dto: AdministrationTimeDto): AdministrationTime
    fun convertDto(administrationTime: AdministrationTime): AdministrationTimeDto

    fun map(time: AdministrationTime): UUID {
        return time.administrationTimeID
    }

    fun map(time: UUID): AdministrationTime {
        return AdministrationTime(time,
            LocalDateTime.now(),0)

    }
}