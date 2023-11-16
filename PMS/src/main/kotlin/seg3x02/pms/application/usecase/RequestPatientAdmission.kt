package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
interface RequestPatientAdmission {
    /**
     * Request a patient admission to the system (UC4)
     * @param admissionRequest PatientAdmissionRequestDto
     * @return UUID? patient admission request id if patient was admitted, null otherwise
     */
    fun requestPatientAdmission(admissionRequestDto: PatientAdmissionRequestDto) : UUID?
}
