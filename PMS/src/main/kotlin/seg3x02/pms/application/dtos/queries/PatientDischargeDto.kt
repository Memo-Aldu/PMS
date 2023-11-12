package seg3x02.pms.application.dtos.queries

import java.sql.Date
import java.sql.Timestamp

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class PatientDischargeDto(
        val patientNAS: String,
        val dischargeReason: String,
        val dischargeDate: Date,
        val dischargeTime: Timestamp,
        val dischargeNurseNAS: String,
        val dischargeNotes: String?
)
