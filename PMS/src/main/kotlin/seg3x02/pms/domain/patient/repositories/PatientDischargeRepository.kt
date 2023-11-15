package seg3x02.pms.domain.patient.repositories

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientDischargeRepository {
    fun save(patientDischarge: PatientDischarge): PatientDischarge
    fun findById(id: UUID): PatientDischarge?
}