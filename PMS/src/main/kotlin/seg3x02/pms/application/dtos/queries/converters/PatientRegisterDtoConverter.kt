package seg3x02.pms.application.dtos.queries.converters
import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.domain.patient.entities.patient.Patient

@Mapper
interface PatientRegisterDtoConverter {

    @Mappings(
        Mapping(target = "nas", ignore = true),
        Mapping(target = "firstName", ignore = true),
        Mapping(target = "lastName", ignore = true),
        Mapping(target = "phoneNumber", ignore = true),
        Mapping(target = "dob", ignore = true),
        Mapping(target = "gender", ignore = true),
        Mapping(target = "maritalStatus", ignore = true),
        Mapping(target = "externalDoctorID", ignore = true),
        Mapping(target = "address", ignore = true),
        Mapping(target = "nextOfKin", ignore = true)
    )
    fun convertDto(dto: PatientRegisterDto): Patient
}