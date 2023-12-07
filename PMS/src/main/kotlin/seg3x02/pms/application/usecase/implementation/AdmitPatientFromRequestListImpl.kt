package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientAdmissionFormRequestDto
import seg3x02.pms.application.usecase.AdmitPatientFromRequestList
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.patient.facade.PatientFacade
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class AdmitPatientFromRequestListImpl(
        private val divisionFacade: DivisionFacade
): AdmitPatientFromRequestList {
    override fun admitPatientFromRequestList(patientToAdmit: PatientAdmissionFormRequestDto): Boolean {
        return divisionFacade.admitPatient(patientToAdmit)
    }
}