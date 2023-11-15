package seg3x02.pms.domain.patient.repositories

import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface ExternalDoctorRepository {
    fun findById(id: UUID): ExternalDoctor?
    fun save(externalDoctor: ExternalDoctor): ExternalDoctor
}