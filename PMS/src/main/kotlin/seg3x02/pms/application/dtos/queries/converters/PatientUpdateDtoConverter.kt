package seg3x02.pms.application.dtos.queries.converters
import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientUpdateDto
import seg3x02.pms.domain.patient.entities.patient.Patient

@Mapper
interface PatientUpdateDtoConverter {
    @Mappings(
        Mapping(target = "nas", ignore = true),
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
    fun convertDto(dto: PatientUpdateDto): Patient
}