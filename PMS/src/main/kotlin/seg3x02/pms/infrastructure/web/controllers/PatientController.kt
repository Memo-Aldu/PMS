package seg3x02.pms.infrastructure.web.controllers
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.validation.Valid
import seg3x02.pms.infrastructure.web.forms.*

import java.util.UUID

@Controller
@SessionAttributes(names = ["division", "patient", "user", "staff"])
class PatientController(
    private val patientService: PatientService,
    private val staffService: StaffService,
    private val divisionService: DivisionService,
    private val prescribeMedicationService: PrescribeMedicationService,
) {
    /** USER / STAFF */

    @GetMapping("/login")
    fun login(model: Model, session: HttpSession): String {
        return "login"
    }

    @GetMapping("/logout")
    fun logout(): String {
        staffService.logout()
        return "redirect:/welcome"
    }

    @GetMapping("/register")
    fun showRegisterStaffForm(model: Model): String {
        model.addAttribute("registerStaffData", RegisterStaffForm())
        model.addAttribute("show", true)
        model.addAttribute("actionUrl", "/staff/register")
        model.addAttribute("actionBtn", "Register Staff")
        return "register"
    }

    @PostMapping("/register")
    fun registerStaff(
        @Valid @ModelAttribute("registerStaffData") registerStaffData: RegisterStaffForm,
        bindingResult: BindingResult
    ): String {
        if (bindingResult.hasErrors()) {
            return "register"
        }

        staffService.registerStaff(registerStaffData)

        return "redirect:/register-success"
    }

    /** ADMISSION */

    /*PATIENT ADMISSION*/

    @GetMapping("/admitPatient/{patientNAS}")
    fun showAdmitPatientForm(
        @PathVariable patientNAS: String,
        model: Model,
        session: HttpSession
    ): String {
        // Assume you have a function to get patient information by NAS
        val patientInfo = patientService.getPatientInfoByNAS(patientNAS)

        if (patientInfo == null) {
            return "redirect:/patientNotFound"
        }

        val divisions = divisionService.getAllDivisions()
        val rooms = divisionService.getAllRooms()
        model.addAttribute("divisions", divisions)
        model.addAttribute("rooms", rooms)
        model.addAttribute("patientAdmissionData", AdmitPatientForm())
        model.addAttribute("patientInfo", patientInfo)
        session.setAttribute("patientNAS", patientNAS)

        return "admitPatient"
    }

    @PostMapping("/admit-patient")
    fun admitPatient(
        @ModelAttribute("patientAdmissionData") patientAdmissionData: AdmitPatientForm,
        bindingResult: BindingResult,
        model: Model,
        principal: Principal?,
        session: HttpSession
    ): String {
        if (bindingResult.hasErrors()) {
            return "admitPatient"
        }
        val patientNAS = session.getAttribute("patientNAS") as String
        val admissionStatus = patientService.admitPatient(patientNAS, patientAdmissionData)
        if (admissionStatus == "success") {
            return "redirect:/admissionSuccess"
        } else {
            return "redirect:/admissionFailure"
        }
    }

    /*REQUEST PATIENT List */
    @GetMapping("/requestList")
    fun showRequestList(model: Model): String {
        val admissionRequests = divisionService.getAllAdmissionRequests()
        model.addAttribute("admissionRequests", admissionRequests)
        return "requestList"
    }

    @GetMapping("/admitPatientFromRequestList/{patientNAS}")
    fun showAdmitPatientFormRequestList(
        @PathVariable patientNAS: String,
        model: Model
    ): String {
        val patientInfo = patientService.getPatientInfoByNAS(patientNAS)

        if (patientInfo == null) {
            return "redirect:/error"
        }
        val divisions = divisionService.getAllDivisions()
        val rooms = divisionService.getAllRooms()
        model.addAttribute("divisions", divisions)
        model.addAttribute("rooms", rooms)
        model.addAttribute("patientAdmissionData", AdmitPatientForm())
        model.addAttribute("patientInfo", patientInfo)
        model.addAttribute("patientNAS", patientNAS)

        return "admitPatient"
    }


    /*REQUEST ADMISSION*/

    @GetMapping("/requestPatientAdmission/{patientNAS}")
    fun showRequestAdmissionForm(
        @PathVariable patientNAS: String,
        model: Model
    ): String {
        val requestAdmissionData = RequestPatientAdmissionForm()
        model.addAttribute("requestAdmissionData", requestAdmissionData)
        model.addAttribute("patientNAS", patientNAS)
        model.addAttribute("divisions", divisionService.getAllDivisions())
        return "requestPatientAdmission"
    }

    @PostMapping("/requestPatientAdmission")
    fun requestAdmission(
        @Valid @ModelAttribute("requestAdmissionData") requestAdmissionData: RequestPatientAdmissionForm,
        bindingResult: BindingResult,
        model: Model,
        principal: Principal?
    ): String {
        if (bindingResult.hasErrors()) {
            return "requestPatientAdmission"
        }

        val requestingChargedNurseNAS = staffService.getCurrentStaffUsername(principal)

        patientService.requestAdmission(requestAdmissionData, requestingChargedNurseNAS)
        return "redirect:/consultPatient/$requestAdmissionData.patientNAS"
    }

    /** PATIENT */

    /*PATIENT UPDATE*/
    @GetMapping("/updatePatient/{nas}")
    fun showUpdatePatientForm(
        @PathVariable nas: String,
        model: Model,
        session: HttpSession
    ): String {
        val patientInfo = patientService.getPatientByNas(nas)

        if (patientInfo == null) {
            // Handle the case where the patient information is not found
            return "redirect:/patientNotFound"
        }
        model.addAttribute("patientUpdateData", PatientRegistrationForm())
        model.addAttribute("patientInfo", patientInfo)
        session.setAttribute("patientNAS", nas)

        return "patientUpdate"
    }

    @PostMapping("/updatePatient")
    fun updatePatient(
        @Valid @ModelAttribute patientUpdateData: PatientRegistrationForm,
        bindingResult: BindingResult,
        model: Model,
        session: HttpSession
    ): String {
        if (bindingResult.hasErrors()) {
            return "updatePatient"
        }
        val patientNAS = session.getAttribute("patientNAS") as String
        val updateStatus = patientService.updatePatient(patientNAS, patientUpdateData)

        if (updateStatus == "success") {
            return "redirect:/consultPatient/$patientNAS"
        } else {
            return "redirect:/error"
        }
    }

    /** PATIENT */

    /*PATIENT REGISTRATION*/

    @GetMapping("/registerPatient")
    fun showRegisterPatientForm(model: Model): String {
        model.addAttribute("patientRegisterData", PatientRegistrationForm())
        return "patientRegistration"
    }

    @PostMapping("/registerPatient")
    fun registerPatient(
        @Valid @ModelAttribute("patientRegisterData") patientRegisterData: PatientRegistrationForm,
        bindingResult: BindingResult,
        model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            return "registerPatient"
        }
        val registrationStatus = patientService.registerPatient(patientRegisterData)
        if (registrationStatus == "success") {
            return "redirect:/welcome"
        } else {
            return "redirect:/registrationFailure"
        }
    }


    /*CONSULT PATIENT*/

    @GetMapping("/consultPatient/{nas}")
    fun consultPatient(
        @PathVariable nas: String,
        model: Model,
        session: HttpSession
    ): String {
        val patientInfo = patientService.getPatientByNas(nas)

        model.addAttribute("patientInfo", patientInfo)
        session.setAttribute("patientNas", nas)
        return "consultPatient"
    }

    /*DISCHARGE PATIENT*/

    @GetMapping("/dischargePatient/{patientNAS}")
    fun dischargePatient(@PathVariable patientNAS: String, model: Model): String {
        val dischargeStatus = patientService.dischargePatient(patientNAS)
        if (dischargeStatus == "success") {
            val patientInfo = patientService.getPatientInfoByNAS(patientNAS)
            model.addAttribute("patientInfo", patientInfo)
            return "consultPatient"
        } else {
            return "redirect:/dischargePatient"
        }
    }
    /**PRESCRIBE MEDICATION*/
    @GetMapping("/prescribeMedication")
    fun showPrescribeMedicationForm(model: Model): String {
        model.addAttribute("prescribeMedicationData", PrescribeMedicationForm())
        return "prescribeMedication"
    }

    @PostMapping("/prescribeMedication")
    fun prescribeMedication(
        @Valid @ModelAttribute("prescribeMedicatioData") prescribeMedicationData: PrescribeMedicationForm,
        bindingResult: BindingResult,
        model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            return "prescribeMedication"
        }

        // Call the prescribeMedicationService to handle the logic
        val prescriptionStatus = prescribeMedicationService.prescribeMedication(prescribeMedicationData)

        if (prescriptionStatus == "success") {
            return "redirect:/consultPatient/${prescribeMedicationData.patientNAS}"
        } else {
            // Handle failure scenario, maybe redirect to an error page
            return "redirect:/prescribeMedication"
        }
    }

    /** DIVISION */

    @GetMapping("/visualizeDivision/{id}")
    fun visualizeDivision(
        @PathVariable id: UUID,
        model: Model,
        session: HttpSession
    ): String {
        val division = divisionService.getDivisionById(id)

        model.addAttribute("division", division)
        session.setAttribute("divisionId", id)
        return "visualizeDivision"
    }
}



