package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientDischargeJpaEntity
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Mapper(componentModel = "spring", uses = [PatientJpaConverter::class,
    StaffJpaConverter::class, DivisionJpaConverter::class])
interface PatientDischargeJpaConverter {
    fun convertToJpaEntity(patientDischarge: PatientDischarge): PatientDischargeJpaEntity
    fun convertToModel(patientDischargeJpaEntity: PatientDischargeJpaEntity): PatientDischarge

}