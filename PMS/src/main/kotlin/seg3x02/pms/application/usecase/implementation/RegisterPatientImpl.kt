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
    private var staffFacade: StaffFacade
): RegisterPatient {

    override fun registerPatient(patient: PatientRegisterDto): String? {
        val patientNextOfKin = patientFacade.createPatientNextOfKin(patient.nextOfKin)
        val patientAddress = patientFacade.createPatientAddress(patient.address)
        val externalDoctor = staffFacade.getStaffById(patient.externalDoctorID)

        if (patientNextOfKin != null && patientAddress != null && externalDoctor != null) {
            val patientNAS = patientFacade.registerPatient(patient)
            patientFacade.setPatientNextOfKin(patient.nas, patientNextOfKin)
            patientFacade.setPatientAddress(patient.nas, patientAddress)
            patientFacade.setPatientExternalDoctor(patient.nas, externalDoctor)
            return patientNAS
        }
        return null
    }
}