package seg3x02.pms.domain.patient.factory

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientAdmissionFactory {
    fun createPatientAdmission(patientAdmissionRequestDto: PatientAdmissionRequestDto): PatientAdmission
}