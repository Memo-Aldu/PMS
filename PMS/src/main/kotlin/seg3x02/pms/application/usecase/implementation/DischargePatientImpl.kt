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
): DischargePatient {
    override fun dischargePatient(patient: PatientDischargeDto): Boolean {
        TODO("Not yet implemented")
    }
}