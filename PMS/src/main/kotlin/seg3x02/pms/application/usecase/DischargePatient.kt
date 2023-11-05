package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.queries.PatientDischargeDto

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
interface DischargePatient {

    /**
     * Discharge a patient from the system (UC8)
     * @param patient PatientDischargeDto
     * @return Boolean true if patient was discharged, false otherwise
     */
    fun dischargePatient(patient: PatientDischargeDto) : Boolean
}