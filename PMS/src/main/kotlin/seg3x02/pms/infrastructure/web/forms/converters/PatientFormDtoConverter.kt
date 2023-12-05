package seg3x02.pms.application.dtos.queries.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.*
import seg3x02.pms.infrastructure.web.forms.AdmitPatientForm
import seg3x02.pms.infrastructure.web.forms.PatientRegistrationForm
import seg3x02.pms.infrastructure.web.forms.RequestPatientAdmissionForm
import java.util.*

@Mapper
abstract class PatientFormDtoConverter {

    @Mappings(
        Mapping(target = "nas", source = "nas"),
        Mapping(target = "firstName", source = "firstName"),
        Mapping(target = "lastName", source = "lastName"),
        Mapping(target = "phoneNumber", source = "phoneNumber"),
        Mapping(target = "dob", source = "dob"),
        Mapping(target = "gender", source = "gender"),
        Mapping(target = "maritalStatus", source = "maritalStatus"),
        Mapping(target = "externalDoctorID", source = "externalDoctorID"),
        Mapping(target = "address", source = "address"),
        Mapping(target = "nextOfKin", source = "nextOfKin")
    )
    abstract fun convertPatientFormToDto(patientRegistrationForm: PatientRegistrationForm): PatientRegisterDto

    @Mappings(
        Mapping(target = "firstName", source = "firstName"),
        Mapping(target = "lastName", source = "lastName"),
        Mapping(target = "phoneNumber", source = "phoneNumber"),
        Mapping(target = "address", source = "address"),
        Mapping(target = "relationship", source = "relationship")
    )
    abstract fun convertNextOfKinFormToDto(nextOfKinForm: PatientNextOfKinRegisterDto): PatientNextOfKinRegisterDto

    fun mapUUID(value: String?): UUID? {
        return value?.let { UUID.fromString(it) }
    }
    @Mappings(
        Mapping(target = "firstName", source = "firstName"),
        Mapping(target = "lastName", source = "lastName"),
        Mapping(target = "phoneNumber", source = "phoneNumber"),
        Mapping(target = "dob", source = "dob"),
        Mapping(target = "gender", source = "gender"),
        Mapping(target = "maritalStatus", source = "maritalStatus"),
        Mapping(target = "externalDoctorID", source = "externalDoctorID"),
        Mapping(target = "address", source = "address"),
        Mapping(target = "nextOfKin", source = "nextOfKin")
    )
    abstract fun convertPatientFormToUpdateDto(patientRegistrationForm: PatientRegistrationForm): PatientUpdateDto

    @Mappings(
        Mapping(target = "patientNAS", source = "patientNAS"),
        Mapping(target = "divisionId", source = "divisionId"),
        Mapping(target = "requestingChargedNurseNAS", source = "requestingChargedNurseNAS"),
        Mapping(target = "approvingChargedNurseNAS", source = "approvingChargedNurseNAS"),
        Mapping(target = "roomId", source = "roomId"),
        Mapping(target = "bedId", source = "bedId"),
        Mapping(target = "optionPrivateInsuranceNumber", source = "optionPrivateInsuranceNumber")
    )
    abstract fun convertAdmitPatientFormToDto(admitPatientForm: AdmitPatientForm): PatientAdmissionToDivisionDto

    @Mappings(
        Mapping(target = "patientNAS", source = "patientNAS"),
        Mapping(target = "rationaleForRequest", source = "rationaleForRequest"),
        Mapping(target = "priorityAssessment", source = "priorityAssessment"),
        Mapping(target = "localRequestingChargedNurseNAS", source = "localRequestingChargedNurseNAS"),
        Mapping(target = "divisionId", source = "divisionId")
    )
    abstract fun convertRequestPatientAdmissionFormToDto(requestPatientAdmissionForm: RequestPatientAdmissionForm): PatientAdmissionRequestDto
}
