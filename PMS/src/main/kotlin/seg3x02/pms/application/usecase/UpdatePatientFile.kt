package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.queries.PatientUpdateDto

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 2023-10-19, Thursday
 **/
interface UpdatePatientFile {
    /**
     * Update a patient's file (UC5)
     * @param updatedPatient PatientUpdateDto
     * @return Boolean true if patient file was updated, false otherwise
     */
    fun updatePatientFile(updatedPatient: PatientUpdateDto) : Boolean
}