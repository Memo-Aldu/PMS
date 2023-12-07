package seg3x02.pms.application.dtos.reponses

import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.enums.DivisionStatus
import seg3x02.pms.domain.staff.entities.Staff
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/

/*    val id: UUID,
    val divisionName: String,
    val location: String,
    val totalBeds: Int,
    val telephoneExtension: String,
) {
    var divisionStatus: DivisionStatus = DivisionStatus.INCOMPLETE
        private set
    lateinit var chargeNurse: Staff
    var staffs: MutableList<String> = ArrayList()
    var patientAdmissionRequestList: MutableList<String> = ArrayList()
    var rooms: MutableList<Room> = ArrayList()*/
data class DivisionBrowsDto(
    val id: UUID,
    val divisionName: String,
    val location: String,
    val totalBeds: Int,
    val telephoneExtension: String,
    var divisionStatus: DivisionStatus,
) {
    constructor(division: Division) : this(
        division.id,
        division.divisionName,
        division.location,
        division.totalBeds,
        division.telephoneExtension,
        division.divisionStatus
    )
}
