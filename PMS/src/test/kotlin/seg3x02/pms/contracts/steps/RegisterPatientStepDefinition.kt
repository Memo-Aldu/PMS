package seg3x02.pms.contracts.steps

import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import seg3x02.pms.application.dtos.queries.ExternalDoctorDto
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.usecase.RegisterPatient
import seg3x02.pms.application.usecase.implementation.RegisterPatientImpl
import seg3x02.pms.contracts.testStubs.factories.*
import seg3x02.pms.contracts.testStubs.repositories.*
import seg3x02.pms.contracts.testStubs.services.EventEmitterStub
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.facade.implementation.PatientFacadeImpl
import seg3x02.pms.domain.staff.entities.Staff
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/15/2023, Wednesday
 **/

class RegisterPatientStepDefinition: En {
    private var patientRepository = PatientRepositoryStub()
    private var patientNextOfKinRepository = PatientNextOfKinRepositoryStub()
    private var staffRepository = StaffRepositoryStub()
    private var patientFactory = PatientFactoryStub()
    private var patientNextOfKinFactory = PatientNextOfKinFactoryStub()
    private var addressFactory = AddressFactoryStub()
    private var externalDoctorFactory = ExternalDoctorFactoryStub()
    private var eventEmitter = EventEmitterStub()
    private var patientAdmissionRepository = PatientAdmissionRepositoryStub()
    private var patientDischargeRepository = DischargeRepositoryStub()
    private var patientDischargeFactory = DischargeFactoryStub()

    private var registeredNurse: Staff? = null
    private var patient: Patient? = null
    private var address: Address? = null
    private var patientCreatedID: String? = null
    private var patientNextOfKin: PatientNextOfKin? = null
    private var externalDoctor: ExternalDoctor? = null
    private var patientInfo: PatientRegisterDto? = null

    init {
        Given("the HMS-PMS system is running") {
            println("System is running")
        }
        And("the staff member registered") {
            // Write code here that turns the phrase above into concrete actions
            registeredNurse = createStaff(staffRepository)
            externalDoctor = createExternalDoctor()
            assert(registeredNurse != null)
        }
        And("staff member is logged in") {
            // Write code here that turns the phrase above into concrete actions
            assert(staffRepository.getStaffById(registeredNurse!!.staffId) != null)
        }
        And("the patient is not registered") {
            // Write code here that turns the phrase above into concrete actions
            patientInfo = createPatientInfo()
            assert(patientRepository.findById(patientInfo!!.nas) == null)
        }
        And("the patient is registered") {
            // Write code here that turns the phrase above into concrete actions
            patientInfo = createPatientInfo()
            patientCreatedID = patientRepository.save(patientFactory.createPatient(patientInfo!!)).nas
            assert(patientCreatedID != null)
        }
        And("the patient's details are valid") {
            // Write code here that turns the phrase above into concrete actions
            assert(patientInfo!!.nas != null && patientInfo!!.nas != ""
                    && patientInfo!!.firstName != null && patientInfo!!.firstName != ""
                    && patientInfo!!.lastName != null && patientInfo!!.lastName != ""
                    && patientInfo!!.phoneNumber != null && patientInfo!!.phoneNumber != ""
                    && patientInfo!!.address != null && patientInfo!!.externalDoctor != null
                    && patientInfo!!.nextOfKin != null)
        }
        And ("the patient's details are invalid") {
            // set nas to null
            val oldExternalDoctor = patientInfo!!.externalDoctor
            val newExternalDoctor = ExternalDoctorDto(
                "Dr. Strange",
                "123-456-7890",
                "1234567889",
                "email@test.com"
            )
            patientInfo!!.externalDoctor = newExternalDoctor
            assert(newExternalDoctor != oldExternalDoctor)
        }
        When("the application command registerPatient is invoked") {
            // Write code here that turns the phrase above into concrete actions
            val patientFacade = PatientFacadeImpl(
                patientRepository,
                patientAdmissionRepository,
                patientNextOfKinRepository,
                patientDischargeRepository,
                patientDischargeFactory,
                patientFactory,
                externalDoctorFactory,
                patientNextOfKinFactory,
                addressFactory,
                eventEmitter
            )
            val uc: RegisterPatient = RegisterPatientImpl(patientFacade)
            patientInfo?.let { patientCreatedID = uc.registerPatient(it) }
            println("Patient Registered Successfully with ID: $patientCreatedID")
        }
        Then("the patient should be registered") {
            // Write code here that turns the phrase above into concrete actions
            assert(patientCreatedID != null && patientRepository.findById(patientCreatedID!!) != null)
        }
        Then("the staff member is not registered to the system") {
            // Write code here that turns the phrase above into concrete actions
            assert(patientCreatedID == null)
        }
        And("the patient's details are stored in the HMS-PMS system") {
            // Write code here that turns the phrase above into concrete actions
            patient = patientRepository.findById(patientCreatedID!!)
            assert(patient != null)

        }
        And("the HMS-PMS system displays an acknowledgement message") {
            // Write code here that turns the phrase above into concrete actions
            println("Patient Registered Successfully with ID: $patientCreatedID")
        }
        And("the HMS-PMS system displays an error message") {
            // Write code here that turns the phrase above into concrete actions
            println("Patient Registration Failed")
        }

       After {_: Scenario ->
            patientRepository = PatientRepositoryStub()
            patientNextOfKinRepository = PatientNextOfKinRepositoryStub()
            staffRepository = StaffRepositoryStub()
            patientFactory = PatientFactoryStub()
            patientNextOfKinFactory = PatientNextOfKinFactoryStub()
            addressFactory = AddressFactoryStub()
            externalDoctorFactory = ExternalDoctorFactoryStub()
            eventEmitter = EventEmitterStub()

            registeredNurse = null
            patient = null
            address = null
            patientCreatedID = null
            patientNextOfKin = null
            externalDoctor = null
            patientInfo = null
       }
    }
}