package seg3x02.pms.contracts.steps

import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.usecase.AdmitPatient
import seg3x02.pms.application.usecase.implementation.AdmitPatientImpl
import seg3x02.pms.contracts.testStubs.factories.*
import seg3x02.pms.contracts.testStubs.repositories.*
import seg3x02.pms.contracts.testStubs.services.EventEmitterStub
import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.enums.BedStatus
import seg3x02.pms.domain.division.enums.DivisionStatus
import seg3x02.pms.domain.division.enums.RoomStatus
import seg3x02.pms.domain.division.facade.implementation.DivisionFacadeImpl
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.facade.implementation.PatientFacadeImpl
import seg3x02.pms.domain.staff.entities.Staff
import java.util.*

class AdmitPatientStepDefinition: En {
    private var patientRepository = PatientRepositoryStub()
    private var divisionRepository = DivisionRepositoryStub()
    private var roomRepository = RoomRepositoryStub()
    private var bedRepository = BedRepositoryStub()
    private var patientAdmissionRepository = PatientAdmissionRepositoryStub()
    private var patientAdmissionRequestRepository = PatientAdmissionRequestRepositoryStub()
    private var patientAdmissionRequestFactory = PatientAdmissionRequestFactoryStub()
    private var patientAdmissionFactory = PatientAdmissionFactoryStub()
    private var patientFactory = PatientFactoryStub()
    private var patientNextOfKinRepository = PatientNextOfKinRepositoryStub()
    private var externalDoctorFactory = ExternalDoctorFactoryStub()
    private var staffRepository = StaffRepositoryStub()
    private var patientNextOfKinFactory = PatientNextOfKinFactoryStub()
    private var addressFactory = AddressFactoryStub()
    private var eventEmitter = EventEmitterStub()
    private var patientDischargeRepository = DischargeRepositoryStub()
    private var patientDischargeFactory = DischargeFactoryStub()

    private var admissionInfo: PatientAdmissionToDivisionDto? = null
    private var registeredNurse: Staff? = null
    private lateinit var patient: Patient;
    private var externalDoctor: ExternalDoctor? = null
    private var patientInfo: PatientRegisterDto? = null
    private var nurseChooseToAdmitPatient = false
    private var admissionID: UUID? = null
    private var division: Division? = null
    private var room: Room? = null
    private var bed: Bed? = null

    init {
        Given("the HMS-PMS is On") {
            println("System is running")
        }
        And("the Charge Nurse is logged in") {
            // Write code here that turns the phrase above into concrete actions
            registeredNurse = createStaff(staffRepository)
            assert(registeredNurse != null)
        }
        And("the Charge Nurse is consulting the patient files") {
            externalDoctor = createExternalDoctor()
            patientInfo = createPatientInfo()
            patient = patientRepository.save(patientFactory.createPatient(patientInfo!!))
        }

        And("Charge Nurse chooses to admit a Patient") {
            nurseChooseToAdmitPatient = true
        }

        And("the division is not full") {
            // Write code here that turns the phrase above into concrete actions
            val divisionInfo = createDivision(DivisionStatus.INCOMPLETE)
            val roomInfo = createRoom(divisionInfo, RoomStatus.NOTCOMPLETE)
            val bedInfo = createBed(roomInfo, BedStatus.AVAILABLE)
            division = divisionRepository.save(divisionInfo)
            room = roomRepository.save(roomInfo)
            bed = bedRepository.save(bedInfo)
            assert(division != null)
            assert(room != null)
            assert(bed != null)
        }

        And("the division is complete") {
            // Write code here that turns the phrase above into concrete actions
            val divisionInfo = createDivision(DivisionStatus.COMPLETE)
            val roomInfo = createRoom(divisionInfo, RoomStatus.COMPLETE)
            val bedInfo = createBed(roomInfo, BedStatus.AVAILABLE)
            division = divisionRepository.save(divisionInfo)
            room = roomRepository.save(roomInfo)
            bed = bedRepository.save(bedInfo)
            assert(division != null)
            assert(room != null)
            assert(bed != null)
        }

        And("Charge Nurse enters the admission information") {
            // Write code here that turns the phrase above into concrete actions
            if (nurseChooseToAdmitPatient)
                admissionInfo = createAdmissionInfo(patient, division!!, room!!, bed!!)
                assert(admissionInfo != null)
        }

        When("the application command admitPatient is invoked") {
            // Write code here that turns the phrase above into concrete actions
            val divisionFacade = DivisionFacadeImpl(
                divisionRepository,
                patientAdmissionRepository,
                patientAdmissionRequestFactory,
                patientAdmissionFactory,
                patientAdmissionRequestRepository,
                bedRepository,
                roomRepository
            )

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
            val uc: AdmitPatient = AdmitPatientImpl(patientFacade, divisionFacade)
            admissionInfo?.let { admissionID = uc.admitPatientToDivision(it) }
        }

        Then("HMS admits the patient to the division") {
                // Write code here that turns the phrase above into concrete actions
                assert(admissionID != null)
        }

        Then("HMS notifies Charge Nurse that her division is complete") {
            // Write code here that turns the phrase above into concrete actions
            assert(admissionID == null)
            println("Division is complete")
        }

        And("HMS gives the possibility to request an admission for the Patient") {
            // Write code here that turns the phrase above into concrete actions
            println("Request an admission")
        }

        After {_: Scenario ->
            patientRepository = PatientRepositoryStub()
            divisionRepository = DivisionRepositoryStub()
            roomRepository = RoomRepositoryStub()
            bedRepository = BedRepositoryStub()
            patientAdmissionRepository = PatientAdmissionRepositoryStub()
            patientAdmissionRequestRepository = PatientAdmissionRequestRepositoryStub()
            patientAdmissionRequestFactory = PatientAdmissionRequestFactoryStub()
            patientAdmissionFactory = PatientAdmissionFactoryStub()
            patientFactory = PatientFactoryStub()
            patientNextOfKinRepository = PatientNextOfKinRepositoryStub()
            externalDoctorFactory = ExternalDoctorFactoryStub()
            staffRepository = StaffRepositoryStub()
            patientNextOfKinFactory = PatientNextOfKinFactoryStub()
            addressFactory = AddressFactoryStub()
            eventEmitter = EventEmitterStub()

            admissionInfo = null
            registeredNurse = null
            externalDoctor = null
            patientInfo = null
            nurseChooseToAdmitPatient = false
            admissionID = null
            division = null
            room = null
            bed = null
       }
    }
}