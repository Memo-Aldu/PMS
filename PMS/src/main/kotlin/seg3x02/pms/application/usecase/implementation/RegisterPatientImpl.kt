package seg3x02.pms.application.usecase.implementation

import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.usecase.RegisterPatient
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.staff.facade.StaffFacade

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class RegisterPatientImpl(
    private var patientFacade: PatientFacade,
): RegisterPatient {

    override fun registerPatient(patient: PatientRegisterDto): String? {
        val patientNextOfKinId = patientFacade.createPatientNextOfKin(patient.nextOfKin)
        val patientAddressId = patientFacade.createPatientAddress(patient.address)
        val externalDoctorId = patientFacade.getExternalDoctor(patient.externalDoctorID)

        if (patientNextOfKinId != null && patientAddressId != null && externalDoctorId != null) {
            val patientNAS = patientFacade.registerPatient(patient)
            patientFacade.setPatientNextOfKin(patient.nas, patientNextOfKinId)
            patientFacade.setPatientAddress(patient.nas, patientAddressId)
            patientFacade.setPatientExternalDoctor(patient.nas, externalDoctorId)
            return patientNAS
        }
        return null
    }
}