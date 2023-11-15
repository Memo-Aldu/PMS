package seg3x02.pms.domain.patient.factory

import seg3x02.pms.application.dtos.queries.PatientDischargeDto
import seg3x02.pms.domain.patient.entities.admission.PatientDischarge

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientDischargeFactory {
    fun createPatientDischarge(patientDischargeDto: PatientDischargeDto): PatientDischarge
}