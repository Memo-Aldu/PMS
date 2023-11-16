package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.division.repositories.PatientAdmissionRequestRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class PatientAdmissionRequestRepositoryStub: PatientAdmissionRequestRepository {
    private val patientAdmissions: MutableMap<UUID, AdmissionRequest> = HashMap()
    override fun findById(id: UUID): AdmissionRequest? {
        return patientAdmissions[id]
    }

    override fun save(admissionRequest: AdmissionRequest): AdmissionRequest {
        patientAdmissions[admissionRequest.id] = admissionRequest
        return admissionRequest
    }

}