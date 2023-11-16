package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.usecase.AdmitPatient
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.patient.facade.PatientFacade
import java.util.*

class AdmitPatientImpl(
    private val divisionFacade: DivisionFacade
) : AdmitPatient {

    override fun admitPatientToDivision(patientAdmissionToDivisionDto: PatientAdmissionToDivisionDto): UUID? {
        val availableRoomsAndBeds = divisionFacade.hasAvailableRooms(patientAdmissionToDivisionDto.divisonId)
        val doesDivisionExist = divisionFacade.doesDivisionExist(patientAdmissionToDivisionDto.divisonId)
        if (!availableRoomsAndBeds!! || !doesDivisionExist) {
            return null
        }
        else
            divisionFacade.admitPatient(patientAdmissionToDivisionDto)

        return null
    }
}
