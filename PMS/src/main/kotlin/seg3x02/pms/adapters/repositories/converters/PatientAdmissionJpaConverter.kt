package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientAdmissionJpaEntity
import java.util.*


/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Mapper(componentModel = "spring", uses = [PatientJpaConverter::class, RoomJpaConverter::class,
    BedJpaConverter::class, DivisionJpaConverter::class, StaffJpaConverter::class ])
interface PatientAdmissionJpaConverter {
    fun convertToJpaEntity(patientAdmission: PatientAdmission): PatientAdmissionJpaEntity
    fun convertToModel(patientAdmissionJpaEntity: PatientAdmissionJpaEntity): PatientAdmission

}
