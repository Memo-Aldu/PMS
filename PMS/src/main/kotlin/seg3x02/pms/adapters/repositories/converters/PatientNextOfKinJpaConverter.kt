package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.infrastructure.jpa.entities.patient.PatientJpaEntity
import seg3x02.pms.infrastructure.jpa.entities.patient.PatientNextOfKinJpaEntity
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Mapper(componentModel = "spring")
interface PatientNextOfKinJpaConverter {
    fun convertToJpaEntity(patientKin: PatientNextOfKin) : PatientNextOfKinJpaEntity
    fun convertToModel(patientKinJpaEntity: PatientNextOfKinJpaEntity) : PatientNextOfKin

}