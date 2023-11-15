package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientDischargeDto
import seg3x02.pms.application.usecase.DischargePatient
import seg3x02.pms.domain.patient.facade.PatientFacade

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class DischargePatientImpl(
    private val patientFacade: PatientFacade
    private val patientRepository: PatientRepository
): DischargePatient {
    override fun dischargePatient(patient: PatientDischargeDto): Boolean {
        val patientToBeDischarged = patientFacade.patientRepository.findById(patient.patientId)
        if (patientToBeDischarged != null) {
            patientToBeDischarged.dischargePatient(patient)
            patientRepository.save(patientToBeDischarged)
            return true
        } else {
            return false
        }
    }
}