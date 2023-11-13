package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientUpdateDto
import seg3x02.pms.application.usecase.UpdatePatientFile
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.staff.facade.StaffFacade

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class UpdatePatientFileImpl(
    private val patientFacade: PatientFacade,
    private val staffFacade: StaffFacade
): UpdatePatientFile {
    override fun updatePatientFile(updatedPatient: PatientUpdateDto, patientNAS: String): Boolean {
        TODO("Not yet implemented")
    }
}