package seg3x02.pms.domain.division.entities

import seg3x02.pms.domain.division.enums.DivisionStatus
import seg3x02.pms.domain.staff.entities.Staff
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
class Division(
    val id: UUID,
    val divisionName: String,
    val location: String,
    val totalBeds: Int,
    val telephoneExtension: String,
    val divisionStatus: DivisionStatus,
) {
    lateinit var chargeNurse: Staff
    var staffs: MutableList<String> = ArrayList()
    var patients: MutableList<String> = ArrayList()
    var patientsAdmissionRequests: MutableList<UUID> = ArrayList()
}