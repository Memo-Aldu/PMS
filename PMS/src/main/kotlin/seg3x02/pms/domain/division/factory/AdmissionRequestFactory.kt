package seg3x02.pms.domain.division.factory

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.domain.division.entities.AdmissionRequest

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface AdmissionRequestFactory {
    fun createAdmissionRequest(admissionRequestDto: PatientAdmissionRequestDto): AdmissionRequest
}