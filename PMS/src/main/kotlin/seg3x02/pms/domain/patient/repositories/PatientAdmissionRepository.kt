package seg3x02.pms.domain.patient.repositories

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientAdmissionRepository {
    fun findById(id: String): PatientAdmission?
    fun finByPatientId(nas: String): PatientAdmission
    fun save(patientAdmission: PatientAdmission): PatientAdmission
}
