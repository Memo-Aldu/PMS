package seg3x02.pms.application.dtos.queries.converters
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.Named
import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.division.enums.RationalOfRequestEnum
import java.util.UUID

@Mapper(componentModel = "spring")
abstract class PatientAdmissionRequestDtoConverter {

         @Mapping(target = "priorityAssessment", source = "priorityAssessment")
         @Mapping(target = "patientNAS", source = "patient.nas")
         @Mapping(target = "localRequestingChargedNurseNAS", source = "requestingChargedNurse.staffId")
        abstract fun convertDto(admissionRequest: AdmissionRequest): PatientAdmissionRequestDto

        @Mapping(target = "priorityAssessment", source = "priorityAssessment")
        @Mapping(target = "patient.nas", source = "patientNAS")
        @Mapping(target = "requestingChargedNurse.staffId", source = "localRequestingChargedNurseNAS")
        abstract fun convertToDomain(dto: PatientAdmissionRequestDto): AdmissionRequest

        fun map(priorityAssessment: RationalOfRequestEnum): Int {
            return priorityAssessment.ordinal
        }

        fun map(priorityAssessment: Int): RationalOfRequestEnum {
            return RationalOfRequestEnum.entries[priorityAssessment]
        }


}