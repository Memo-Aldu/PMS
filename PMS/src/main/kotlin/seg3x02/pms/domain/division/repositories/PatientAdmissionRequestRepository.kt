package seg3x02.pms.domain.division.repositories

import seg3x02.pms.domain.division.entities.AdmissionRequest

interface PatientAdmissionRequestRepository {
    fun findById(id: String): AdmissionRequest?
    fun save(admissionRequest: AdmissionRequest): AdmissionRequest
}