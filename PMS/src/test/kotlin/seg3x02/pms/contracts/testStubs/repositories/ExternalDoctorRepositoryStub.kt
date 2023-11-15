package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.repositories.ExternalDoctorRepository
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class ExternalDoctorRepositoryStub : ExternalDoctorRepository {
    private val patientNextOfKins: MutableMap<UUID, ExternalDoctor> = HashMap()
    override fun findById(id: UUID): ExternalDoctor? {
        return patientNextOfKins[id]
    }

    override fun save(externalDoctor: ExternalDoctor): ExternalDoctor {
        patientNextOfKins[externalDoctor.id] = externalDoctor
        return externalDoctor
    }

}