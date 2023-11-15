package seg3x02.pms.domain.patient.repositories

import seg3x02.pms.domain.patient.entities.patient.Patient

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientRepository {
    fun findById(nas: String): Patient?
    fun save(patient: Patient): Patient
}