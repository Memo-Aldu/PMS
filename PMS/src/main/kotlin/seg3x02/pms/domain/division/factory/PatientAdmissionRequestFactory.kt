package seg3x02.pms.domain.division.factory

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.domain.division.entities.AdmissionRequest

interface PatientAdmissionRequestFactory {
    fun createPatientAdmissionRequest(patientAdmissionRequestDto: PatientAdmissionRequestDto): AdmissionRequest
}