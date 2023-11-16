package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.domain.patient.repositories.PatientAdmissionRepository
import java.util.*

class PatientAdmissionRepositoryStub: PatientAdmissionRepository {
    private val patientAdmissions: MutableMap<UUID, PatientAdmission> = HashMap()
    override fun save(patientAdmission: PatientAdmission): PatientAdmission {
        patientAdmissions[patientAdmission.id] = patientAdmission
        return patientAdmission
    }

    override fun findById(id: UUID): PatientAdmission? {
        return patientAdmissions[id]
    }
    
    override fun findByPatientNAS(nas: String): PatientAdmission? {
        return patientAdmissions.values.find { it.patient.nas == nas }
    }

}
