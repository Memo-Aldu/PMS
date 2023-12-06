package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
@Mapper(componentModel = "spring")
interface AdministrationTimeJpaConverter {
    fun convertToJpaEntity(administrationTime: seg3x02.pms.domain.prescription.entities.AdministrationTime): seg3x02.pms.infrastructure.jpa.entities.prescription.AdministrationTimeJpaEntity
    fun convertToModel(administrationTimeJpaEntity: seg3x02.pms.infrastructure.jpa.entities.prescription.AdministrationTimeJpaEntity): seg3x02.pms.domain.prescription.entities.AdministrationTime
}