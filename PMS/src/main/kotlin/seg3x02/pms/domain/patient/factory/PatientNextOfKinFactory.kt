package seg3x02.pms.domain.patient.factory

import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientNextOfKinFactory {
    fun createPatientNextOfKin(patientNextOfKin: PatientNextOfKinRegisterDto): PatientNextOfKin
}