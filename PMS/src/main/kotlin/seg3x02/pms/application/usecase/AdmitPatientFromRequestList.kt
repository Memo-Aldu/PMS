package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.queries.PatientAdmissionFormRequestDto
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
interface AdmitPatientFromRequestList {
    /**
     * Admit a patient from the request list (UC7)
     * @param patientToAdmit PatientAdmissionFormRequestDto
     * @return Boolean
     */
    fun admitPatientFromRequestList(patientToAdmit: PatientAdmissionFormRequestDto) : Boolean

}