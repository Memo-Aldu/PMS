package seg3x02.pms.application.dtos.queries

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
data class PatientDischargeDto(
        val patientNAS: String,
        val dischargeReason: String,
        val dischargeDate: String,
        val dischargeTime: String,
        val dischargeNurseNAS: String,
        val dischargeNotes: String?
)
