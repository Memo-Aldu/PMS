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

    override fun admitPatientToDivision(patient: PatientAdmissionToDivisionDto): UUID? {
        val doesPatientExist = patientFacade.doesPatientExist(patient.patientNAS)
        val doesDivisionExist = divisionFacade.doesDivisionExist(patient.divisonId)
        val availableRoomsAndBeds = divisionFacade.hasAvailableRooms(patient.divisonId)
        if (availableRoomsAndBeds!! && doesDivisionExist && doesPatientExist) {
            divisionFacade.admitPatient(patient)
        }
        return null
    }
}
