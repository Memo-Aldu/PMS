package seg3x02.pms.adapters.repositories.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.infrastructure.jpa.entities.division.AdmissionRequestJpaEntity

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/5/2023, Tuesday
 **/
@Mapper(componentModel = "spring", uses = [PatientJpaConverter::class])
interface AdmissionRequestJpaConverter {

    @Mapping(target = "requestingChargedNurse", source = "requestingChargedNurse")
    @Mapping(target = "patient", source = "patient")
    @Mapping(target = "division.id", source = "divisionId")
    @Mapping(target = "rationaleForRequest", source = "rationaleForRequest")
    @Mapping(target = "priorityAssessment", source = "priorityAssessment")
    @Mapping(target = "id", source = "id")
    fun convertToJpaEntity(admissionRequest: AdmissionRequest): AdmissionRequestJpaEntity

    @Mapping(target = "requestingChargedNurse", source = "requestingChargedNurse")
    @Mapping(target = "patient", source = "patient")
    @Mapping(target = "divisionId", source = "division.id")
    @Mapping(target = "rationaleForRequest", source = "rationaleForRequest")
    @Mapping(target = "priorityAssessment", source = "priorityAssessment")
    @Mapping(target = "id", source = "id")
    fun convertToModel(admissionRequestJpaEntity: AdmissionRequestJpaEntity): AdmissionRequest

}