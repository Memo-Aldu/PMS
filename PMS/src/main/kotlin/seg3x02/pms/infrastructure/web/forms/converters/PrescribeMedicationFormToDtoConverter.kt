package seg3x02.pms.infrastructure.web.forms.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.AdministrationTimeDto
import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import seg3x02.pms.infrastructure.web.forms.AdministrationTimeForm
import seg3x02.pms.infrastructure.web.forms.PrescribeMedicationForm
import java.time.LocalDateTime

@Mapper
abstract class PrescribeMedicationFormToDtoConverter {

    @Mappings(
        Mapping(target = "patientNAS", source = "patientNAS"),
        Mapping(target = "prescribingDoctorId", source = "prescribingDoctorId"),
        Mapping(target = "drugNumber", source = "drugNumber"),
        Mapping(target = "drugName", source = "drugName"),
        Mapping(target = "unitsByDay", source = "unitsByDay"),
        Mapping(target = "numberOfAdministrationPerDay", source = "numberOfAdministrationPerDay"),
        Mapping(target = "administrationTimes", source = "administrationTimes"),
        Mapping(target = "methodOfAdministration", source = "methodOfAdministration"),
        Mapping(target = "startDate", source = "startDate"),
        Mapping(target = "endDate", source = "endDate")
    )
    abstract fun convertToDto(prescribeMedicationForm: PrescribeMedicationForm): MedicationPrescriptionDto

    fun mapLocalDateTime(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it) }
    }
    @Mappings(
        Mapping(target = "timeOfDay", source = "timeOfDay"),
        Mapping(target = "unitsAdministered", source = "unitsAdministered")
    )
    abstract fun convertAdministrationTimeFormToDto(administrationTimeForm: AdministrationTimeForm): AdministrationTimeDto

}
