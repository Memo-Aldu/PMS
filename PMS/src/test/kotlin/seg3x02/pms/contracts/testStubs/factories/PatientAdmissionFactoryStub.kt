package seg3x02.pms.contracts.testStubs.factories

import seg3x02.pms.application.dtos.queries.PatientAdmissionFormRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.domain.patient.factory.PatientAdmissionFactory
import java.util.*

class PatientAdmissionFactoryStub: PatientAdmissionFactory {

    override fun createPatientAdmission(patientAdmissionToDivisionDto: PatientAdmissionToDivisionDto): PatientAdmission {
        return PatientAdmission(patientAdmissionToDivisionDto.admissionId
        )
    }

    override fun createPatientAdmission(
        patientAdmissionFormRequestDto: PatientAdmissionFormRequestDto,
        request: AdmissionRequest
    ): PatientAdmission {
        return PatientAdmission(patientAdmissionFormRequestDto.requestId)
    }
}