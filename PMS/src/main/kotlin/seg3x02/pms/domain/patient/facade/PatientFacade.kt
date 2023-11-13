package seg3x02.pms.domain.patient.facade

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.PatientDischargeDto
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import java.util.UUID

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface PatientFacade {
    fun registerPatient(patient: PatientRegisterDto): String?
    fun createPatientNextOfKin(nextOfKin: PatientNextOfKinRegisterDto): PatientNextOfKin?
    fun createPatientAddress(address: AddressRegisterDto): Address?
    fun setPatientNextOfKin(patientNAS: String, patientNextOfKin: PatientNextOfKin) : UUID?
    fun setPatientAddress(patientNAS: String, patientAddress: Address) : UUID?
}