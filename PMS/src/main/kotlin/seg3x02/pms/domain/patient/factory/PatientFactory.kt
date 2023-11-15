package seg3x02.pms.domain.patient.factory

import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.dtos.queries.PatientUpdateDto
import seg3x02.pms.domain.patient.entities.patient.Patient

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientFactory {
    fun createPatient(patient: PatientRegisterDto): Patient
    fun createPatient(patientEntity: Patient, patient: PatientUpdateDto): Patient

}