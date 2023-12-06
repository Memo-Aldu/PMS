/*
package seg3x02.pms.infrastructure.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.application.usecase.*
import seg3x02.pms.application.usecase.implementation.*
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.division.facade.implementation.DivisionFacadeImpl
import seg3x02.pms.domain.division.factory.DivisionFactory
import seg3x02.pms.domain.division.factory.PatientAdmissionRequestFactory
import seg3x02.pms.domain.division.repositories.BedRepository
import seg3x02.pms.domain.division.repositories.DivisionRepository
import seg3x02.pms.domain.division.repositories.PatientAdmissionRequestRepository
import seg3x02.pms.domain.division.repositories.RoomRepository
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.patient.facade.implementation.PatientFacadeImpl
import seg3x02.pms.domain.patient.factory.*
import seg3x02.pms.domain.patient.repositories.*
import seg3x02.pms.domain.prescription.facade.PrescriptionFacade
import seg3x02.pms.domain.prescription.facade.implementation.PrescriptionFacadeImpl
import seg3x02.pms.domain.prescription.factory.MedicationPrescriptionFactory
import seg3x02.pms.domain.prescription.repository.MedicationPrescriptionRepository
import seg3x02.pms.domain.staff.facade.StaffFacade
import seg3x02.pms.domain.staff.facade.implementation.StaffFacadeImpl
import seg3x02.pms.domain.staff.repository.StaffRepository



@Configuration
class BeanConfiguration {
    // TODO: UNCOMMENT ONCE ADAPTER IMPLEMENTED
    // TODO ADD USER FACADE ONCE IMPLEMENTED

    @Bean
    fun admitPatientUseCase(
        patientFacade: PatientFacade,
        divisionFacade: DivisionFacade,
    ): AdmitPatient {
        return AdmitPatientImpl(patientFacade, divisionFacade)
    }

    @Bean
    fun patientFacade(
        patientRepository: PatientRepository,
        patientAdmissionRepository: PatientAdmissionRepository,
        patientNextOfKinRepository: PatientNextOfKinRepository,
        patientDischargeRepository: PatientDischargeRepository,
        patientFactory: PatientFactory,
        patientDischargeFactory: PatientDischargeFactory,
        externalDoctorFactory: ExternalDoctorFactory,
        patientNextOfKinFactory: PatientNextOfKinFactory,
        addressFactory: AddressFactory,
        eventEmitter: DomainEventEmitter,

        ): PatientFacade {
        return PatientFacadeImpl(
            patientRepository, patientAdmissionRepository,
            patientNextOfKinRepository, patientDischargeRepository,
            patientDischargeFactory, patientFactory, externalDoctorFactory,
            patientNextOfKinFactory, addressFactory, eventEmitter,
        )
    }

    @Bean
    fun divisionFacade(
        divisionRepository: DivisionRepository,
        patientAdmissionRepository: PatientAdmissionRepository,
        patientAdmissionRequestFactory: PatientAdmissionRequestFactory,
        patientAdmissionFactory: PatientAdmissionFactory,
        patientAdmissionRequestRepository: PatientAdmissionRequestRepository,
        bedRepository: BedRepository,
        roomRepository: RoomRepository,
    ): DivisionFacade {
        return DivisionFacadeImpl(
            divisionRepository, patientAdmissionRepository,
            patientAdmissionRequestFactory, patientAdmissionFactory,
            patientAdmissionRequestRepository, bedRepository, roomRepository,
        )
    }

    @Bean
    fun admitPatientFromRequestListUseCase(
        divisionFacade: DivisionFacade
    ): AdmitPatientFromRequestList {
        // TODO: ADD DEPENDENCIES ONCE USE CASE IS IMPLEMENTED
        return AdmitPatientFromRequestListImpl(divisionFacade)
    }

    @Bean
    fun dischargePatientUseCase(
        patientFacade: PatientFacade,
    ): DischargePatient {
        return DischargePatientImpl(patientFacade)
    }

    @Bean
    fun prescribeMedicationUseCase(
        prescriptionFacade: PrescriptionFacade,
        patientFacade: PatientFacade,
        staffFacade: StaffFacade,
    ): PrescribeMedication {
        return PrescribeMedicationImpl(prescriptionFacade, patientFacade, staffFacade)
    }

    @Bean
    fun prescriptionFacade(
        prescriptionRepository: MedicationPrescriptionRepository,
        prescriptionFactory: MedicationPrescriptionFactory,
        eventEmitter: DomainEventEmitter,
    ): PrescriptionFacade {
        return PrescriptionFacadeImpl(
            prescriptionRepository, prescriptionFactory, eventEmitter,
        )
    }

    @Bean
    fun staffFacade(
        staffRepository: StaffRepository
    ): StaffFacade {
        return StaffFacadeImpl(staffRepository)
    }

    fun registerPatientUseCase(
        patientFacade: PatientFacade,
    ): RegisterPatient {
        return RegisterPatientImpl(patientFacade)
    }

    @Bean
    // TODO: ADD DEPENDENCIES ONCE USE CASE IS IMPLEMENTED
    fun registerStaffUseCase(
        staffFacade: StaffFacade,
    ): RegisterStaff {
        return RegisterStaffImpl(staffFacade)
    }


    @Bean
    fun requestPatientAdmissionUseCase(
        patientFacade: PatientFacade,
        divisionFacade: DivisionFacade
    ): RequestPatientAdmission {
        return RequestPatientAdmissionImpl(patientFacade, divisionFacade)
    }

    @Bean
    fun updatePatientFileUseCase(
        patientFacade: PatientFacade,
    ): UpdatePatientFile {
        return UpdatePatientFileImpl(patientFacade)
    }

}
*/
