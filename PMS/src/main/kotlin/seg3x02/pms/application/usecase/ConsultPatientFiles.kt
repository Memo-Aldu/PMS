package seg3x02.pms.application.usecase

import seg3x02.pms.application.dtos.reponses.PatientFileBrowseDto

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
interface ConsultPatientFiles {
    fun consultPatientFiles(nas: String): PatientFileBrowseDto?
}