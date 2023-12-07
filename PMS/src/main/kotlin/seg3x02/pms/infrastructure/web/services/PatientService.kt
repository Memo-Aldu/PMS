package seg3x02.pms.infrastructure.web.services

import org.springframework.stereotype.Service
import seg3x02.pms.infrastructure.web.forms.AdmitPatientForm
import seg3x02.pms.infrastructure.web.forms.PatientRegistrationForm
import seg3x02.pms.infrastructure.web.forms.RequestPatientAdmissionForm

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/6/2023, Wednesday
 **/
@Service
class PatientService {
    fun getPatientInfoByNAS(patientNAS: String): Any? {
        TODO("Not yet implemented")
    }

    fun admitPatient(patientNAS: String, patientAdmissionData: AdmitPatientForm): Any {
            TODO("Not yet implemented")
    }

    fun requestAdmission(requestAdmissionData: RequestPatientAdmissionForm, requestingChargedNurseNAS: Any) {
            TODO("Not yet implemented")
    }

    fun updatePatient(patientNAS: String, patientUpdateData: PatientRegistrationForm): Any {
            TODO("Not yet implemented")
    }

    fun registerPatient(patientRegisterData: PatientRegistrationForm): Any {
                TODO("Not yet implemented")
    }

    fun dischargePatient(patientNAS: String): Any {
                TODO("Not yet implemented")
    }
}