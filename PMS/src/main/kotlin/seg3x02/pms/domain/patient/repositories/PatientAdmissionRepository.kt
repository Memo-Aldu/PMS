package seg3x02.pms.domain.patient.repositories

import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientAdmissionRepository {
    fun findById(id: UUID): PatientAdmission?
    fun save(patientAdmission: PatientAdmission): PatientAdmission
}
