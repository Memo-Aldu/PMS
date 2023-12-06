package seg3x02.pms.domain.division.facade

import seg3x02.pms.application.dtos.queries.PatientAdmissionFormRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import java.util.UUID

interface DivisionFacade {
    fun admitPatient(admissionRequest: PatientAdmissionToDivisionDto): Boolean
    fun admitPatient(admissionFormRequest: PatientAdmissionFormRequestDto): Boolean
    fun requestPatientAdmission( admissionRequest: PatientAdmissionRequestDto): Boolean
    fun hasAvailableRooms(divisionId: UUID): Boolean?
    fun getNotCompleteRooms(divisionId: UUID): List<Room>?
    fun doesDivisionExist(divisionId: UUID): Boolean
    fun doesAdmissionRequestExist(requestId: UUID): Boolean
}
