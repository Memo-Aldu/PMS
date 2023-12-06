package seg3x02.pms.infrastructure.jpa.dao

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import seg3x02.pms.infrastructure.jpa.entities.patient.admission.PatientAdmissionJpaEntity
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/3/2023, Sunday
 **/

@Repository
interface PatientAdmissionJpaRepository: CrudRepository<PatientAdmissionJpaEntity, UUID> {
    @Query("SELECT * FROM patient_admission WHERE patient_nas = ?1", nativeQuery = true)
    fun findByPatientNAS(nas: String): PatientAdmissionJpaEntity?
}