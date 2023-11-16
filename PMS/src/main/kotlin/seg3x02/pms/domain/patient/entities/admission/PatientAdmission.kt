package seg3x02.pms.domain.patient.entities.admission

import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.staff.entities.Staff
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-11-11, Saturday
 **/
class PatientAdmission(
    val id: UUID
) {

    lateinit var room: Room
    lateinit var bed: Bed
    lateinit var patient: Patient
    lateinit var division: Division
    lateinit var requestingChargedNurse: Staff
    lateinit var acceptingChargedNurse: Staff
}