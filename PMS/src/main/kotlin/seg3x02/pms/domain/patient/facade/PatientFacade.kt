package seg3x02.pms.domain.patient.facade

import seg3x02.pms.application.dtos.queries.*
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.staff.entities.Staff
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientFacade {
    fun registerPatient(patient: PatientRegisterDto): String?
    fun updatePatientFile(updatedPatient: PatientUpdateDto, patientNAS: String): Boolean
    fun patientExists(patientNAS: String): Boolean
    fun addPrescriptionToPatient(patientNAS: String, prescriptionID: UUID)

}