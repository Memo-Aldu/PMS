package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
interface AdmitPatient {
    /**
     * Admit a patient to a division (UC3)
     * @param patient PatientAdmissionRequestDto
     * @return Boolean true if patient was admitted, false otherwise
     */
    fun admitPatientToDivision(patient: PatientAdmissionToDivisionDto) :  UUID?
}
