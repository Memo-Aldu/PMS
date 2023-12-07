package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.infrastructure.jpa.entities.patient.PatientJpaEntity

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/

@Mapper(componentModel = "spring", uses = [PatientNextOfKinJpaConverter::class,
    MedicationPrescriptionJpaConverter::class])
interface PatientJpaConverter {
    @Mapping(target = "prescriptions", ignore = true)
    fun convertToJpaEntity(patient: Patient) : PatientJpaEntity

    @Mapping(target = "prescriptions", ignore = true)
    fun convertToModel(patientJpaEntity: PatientJpaEntity) : Patient
}