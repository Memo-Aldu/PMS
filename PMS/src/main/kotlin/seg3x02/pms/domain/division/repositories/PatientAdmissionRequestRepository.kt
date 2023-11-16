package seg3x02.pms.domain.division.repositories

import seg3x02.pms.domain.division.entities.AdmissionRequest
import java.util.UUID

interface PatientAdmissionRequestRepository {
    fun findById(id: UUID): AdmissionRequest?
    fun save(admissionRequest: AdmissionRequest): AdmissionRequest
}