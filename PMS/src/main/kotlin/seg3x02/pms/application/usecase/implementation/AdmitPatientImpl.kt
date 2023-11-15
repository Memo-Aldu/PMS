package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.usecase.AdmitPatient
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.patient.facade.PatientFacade
import java.util.*

class AdmitPatientImpl(
    private val patientFacade: PatientFacade,
    private val divisionFacade: DivisionFacade
) : AdmitPatient {

    override fun admitPatientToDivision(admissionDto: PatientAdmissionToDivisionDto): UUID? {
        val availableRoomsAndBeds = divisionFacade.hasAvailableRooms(admissionDto.divisonId)
        val doesPatientExist = patientFacade.isPatientAdmitted(admissionDto.patientNAS)
        val doesDivisionExist = divisionFacade.doesDivisionExist(admissionDto.divisonId)
        if (!availableRoomsAndBeds || !doesPatientExist || !doesDivisionExist) {
            return null
        }
        else
            divisionFacade.admitPatient(admissionDto)

        return null
    }
}
