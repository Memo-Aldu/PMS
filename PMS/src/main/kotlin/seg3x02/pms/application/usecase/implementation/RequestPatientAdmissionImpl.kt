package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.application.usecase.RequestPatientAdmission
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.patient.facade.PatientFacade
import java.util.*

class RequestPatientAdmissionImpl(
    private val patientFacade: PatientFacade,
    private val divisionFacade: DivisionFacade
) : RequestPatientAdmission {

    override fun requestPatientAdmission(requestDto: PatientAdmissionRequestDto): UUID? {
        val isPatientAdmitted = patientFacade.isPatientAdmitted(requestDto.patientNAS)
        val doesPatientExist = patientFacade.doesPatientExist(requestDto.patientNAS)
        if (isPatientAdmitted || !doesPatientExist) {
            return null;
        }
        else
            divisionFacade.requestPatientAdmission(requestDto);
        return null;
    }
}
