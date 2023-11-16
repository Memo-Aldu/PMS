package seg3x02.pms.contracts.steps

import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room

import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.usecase.AdmitPatient
import seg3x02.pms.application.usecase.RegisterPatient
import seg3x02.pms.application.usecase.implementation.RegisterPatientImpl
import seg3x02.pms.contracts.testStubs.factories.AddressFactoryStub
import seg3x02.pms.contracts.testStubs.factories.PatientAdmissionFactoryStub
import seg3x02.pms.contracts.testStubs.factories.PatientFactoryStub
import seg3x02.pms.contracts.testStubs.factories.PatientNextOfKinFactoryStub
import seg3x02.pms.contracts.testStubs.repositories.*
import seg3x02.pms.contracts.testStubs.services.EventEmitterStub
import seg3x02.pms.domain.division.facade.implementation.DivisionFacadeImpl
import seg3x02.pms.domain.division.factory.PatientAdmissionRequestFactory
import seg3x02.pms.domain.division.repositories.BedRepository
import seg3x02.pms.domain.division.repositories.PatientAdmissionRequestRepository
import seg3x02.pms.domain.division.repositories.RoomRepository
import seg3x02.pms.domain.patient.entities.admission.PatientAdmission
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.entities.patient.Patient
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.facade.implementation.PatientFacadeImpl
import seg3x02.pms.domain.patient.factory.PatientAdmissionFactory
import seg3x02.pms.domain.patient.repositories.PatientAdmissionRepository
import seg3x02.pms.domain.staff.entities.Staff
import java.util.*

class AdmitPatientStepDefinition: En {
    private var patientRepository = PatientRepositoryStub()
    private var divisionRepository = DivisionRepositoryStub()
    private var roomRepository = RoomRepositoryStub()
    private var bedRepository = BedRepositoryStub()
    private var patientAdmissionRequestFactory = PatientAdmissionFactoryStub()
    private var patientAdmissionRepository = PatientAdmissionRepositoryStub()
    private var patientFactory = PatientFactoryStub()
    private var patientAdmissionFactory = AddressFactoryStub()

    private var id: UUID? = null,
    private var patient: Patient? = null
    private var division: Division? = null
    private var room: Room? = null
    private var bed: Bed? = null
    private var optionPrivateInsuranceNumber: String? = null

    init {
        Given("the HMS-PMS system is running") {
            println("System is running")
        }
        And("the staff member registered") {
        }
        And("consulting the patient files") {
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
                roomRepository,
            )
    }
}