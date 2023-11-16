package seg3x02.pms.domain.division.factory

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface AdmissionToDivisionFactory {
    fun createAdmissionToDivision(admissionToDivisionDto: PatientAdmissionToDivisionDto): PatientAdmission
}
