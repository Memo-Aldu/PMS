package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.queries.PatientRegisterDto

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
interface RegisterPatient {
    /**
     * Register a patient to the system (UC1)
     * @param patient PatientRegisterDto
     * @return String? patient NAS if patient was registered, null otherwise
     */
    fun registerPatient(patient: PatientRegisterDto) : String?
}