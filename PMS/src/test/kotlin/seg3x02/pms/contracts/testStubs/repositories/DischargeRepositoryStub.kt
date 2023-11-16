package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.repositories.BedRepository
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.repositories.PatientDischargeRepository
import java.util.*

class DischargeRepositoryStub: PatientDischargeRepository {
    private val beds: MutableMap<UUID, PatientDischarge> = HashMap()

    override fun save(patientDischarge: PatientDischarge): PatientDischarge {
        beds[patientDischarge.id] = patientDischarge
        return patientDischarge
    }

    override fun findById(id: UUID): PatientDischarge? {
        return beds[id]
    }


}