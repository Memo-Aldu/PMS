package seg3x02.pms.application.dtos.queries.converters

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.staff.entities.Staff
import java.util.*

@Mapper
interface PatientAdmissionDtoConverter {
    @Mappings(
        Mapping(target = "id", ignore = true),
        Mapping(target = "room", ignore = true),
        Mapping(target = "bed", ignore = true),
        Mapping(target = "patient", ignore = true),
        Mapping(target = "division", ignore = true),
        Mapping(target = "requestingChargedNurse", ignore = true),
        Mapping(target = "acceptingChargedNurse", ignore = true)
    )
    fun convertDto(dto: PatientAdmissionToDivisionDto): PatientAdmission
    // If there are mappings with different names, you can specify them explicitly
    @Mapping(target = "roomId", source = "room.id")
    fun mapRoomId(room: Room): UUID

    @Mapping(target = "bedId", source = "bed.id")
    fun mapBedId(bed: Bed): UUID

    @Mapping(target = "divisionId", source = "division.id")
    fun mapDivisionId(division: Division): UUID

    @Mapping(target = "requestingChargedNurseNAS", source = "requestingChargedNurse.nas")
    fun mapRequestingChargedNurseNAS(requestingChargedNurse: Staff): String

    @Mapping(target = "approvingChargedNurseNAS", source = "acceptingChargedNurse.nas")
    fun mapApprovingChargedNurseNAS(acceptingChargedNurse: Staff): String

}