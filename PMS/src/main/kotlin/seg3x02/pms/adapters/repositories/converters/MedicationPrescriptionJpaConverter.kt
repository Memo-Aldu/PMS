package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3x02.pms.domain.prescription.entities.MedicationPrescription
import seg3x02.pms.infrastructure.jpa.entities.prescription.MedicationPrescriptionJpaEntity
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Mapper(componentModel = "spring", uses = [AdministrationTimeJpaConverter::class])
interface MedicationPrescriptionJpaConverter {

    fun convertToJpaEntity(medicationPrescription: MedicationPrescription): MedicationPrescriptionJpaEntity
    fun convertToModel(medicationPrescriptionJpaEntity: MedicationPrescriptionJpaEntity): MedicationPrescription


}