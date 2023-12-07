package seg3x02.pms.application.dtos.queries.converters

import seg3x02.pms.application.dtos.queries.MedicationPrescriptionDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.application.dtos.queries.AdministrationTimeDto
import seg3x02.pms.domain.prescription.entities.AdministrationTime
import seg3x02.pms.domain.prescription.entities.MedicationPrescription

@Mapper
interface MedicationPrescriptionDtoConverter {

    @Mappings(
        Mapping(target = "patientNAS", source = "patient.nas"),
        Mapping(target = "prescribingDoctorId", source = "prescribingDoctorId"),
        Mapping(target = "drugNumber", source = "drugNumber"),
        Mapping(target = "drugName", source = "drugName"),
        Mapping(target = "uniteByDay", source = "uniteByDay"),
        Mapping(target = "numberOfAdministrationPerDay", source = "numberOfAdministrationPerDay"),
        Mapping(target = "administrationTimes", source = "administrationTimes"),
        Mapping(target = "methodOfAdministration", source = "methodOfAdministration"),
        Mapping(target = "startDate", source = "startDate"),
        Mapping(target = "endDate", source = "endDate")
    )
    fun convertDto(dto: MedicationPrescriptionDto): MedicationPrescription

    @Mappings(
        Mapping(target = "timeOfDay", source = "timeOfDay"),
        Mapping(target = "unitesAdministered", source = "unitesAdministered")
    )
    fun convertDto(dto: AdministrationTimeDto): AdministrationTime

}