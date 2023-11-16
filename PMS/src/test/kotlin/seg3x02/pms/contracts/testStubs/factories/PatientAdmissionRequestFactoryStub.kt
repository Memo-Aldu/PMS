package seg3x02.pms.contracts.testStubs.factories

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.division.enums.RationalOfRequestEnum
import seg3x02.pms.domain.division.factory.PatientAdmissionRequestFactory
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/
class PatientAdmissionRequestFactoryStub: PatientAdmissionRequestFactory {
    override fun createPatientAdmissionRequest(patientAdmissionRequestDto: PatientAdmissionRequestDto): AdmissionRequest {
        return AdmissionRequest(
            UUID.randomUUID(),
            patientAdmissionRequestDto.divisionId,
            patientAdmissionRequestDto.rationaleForRequest,
            RationalOfRequestEnum.valueOf(patientAdmissionRequestDto.priorityAssessment.toString()),
        )
    }
}