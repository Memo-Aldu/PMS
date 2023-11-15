package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.usecase.AdmitPatient
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.patient.facade.PatientFacade

class AdmitPatientImpl(
    private val patientFacade: PatientFacade,
    private val divisionFacade: DivisionFacade
) : AdmitPatient {

    override fun admitPatientToDivision(admissionDto: PatientAdmissionToDivisionDto): Boolean {
        val availableRoomsAndBeds = divisionFacade.hasAvailableRooms(admissionDto.divisonId)
        val doesPatientExist = patientFacade.isPatientAdmitted(admissionDto.patientNAS)
        if (!availableRoomsAndBeds || !doesPatientExist) {
            return false
        }
        divisionFacade.admitPatient(admissionDto)

        return true;
    }
}