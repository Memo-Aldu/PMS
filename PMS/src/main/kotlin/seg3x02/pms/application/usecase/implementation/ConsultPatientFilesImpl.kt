package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.ExternalDoctorDto
import seg3x02.pms.application.dtos.reponses.PatientFileBrowseDto
import seg3x02.pms.application.enums.MaritalStatusEnum
import seg3x02.pms.application.enums.PatientKinRelationshipEnum
import seg3x02.pms.application.usecase.ConsultPatientFiles
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.facade.PatientFacade

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
class ConsultPatientFilesImpl(
    private val patientFacade: PatientFacade
): ConsultPatientFiles {
    override fun consultPatientFiles(nas: String): PatientFileBrowseDto? {
        val patient = patientFacade.getPatientFile(nas) ?: return null
        return PatientFileBrowseDto(patient)

    }
}