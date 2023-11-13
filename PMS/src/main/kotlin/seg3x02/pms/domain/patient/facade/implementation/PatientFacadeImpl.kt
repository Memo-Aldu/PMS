package seg3x02.pms.domain.patient.facade.implementation

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.events.PatientCreatedEvent
import seg3x02.pms.domain.patient.events.PatientNextOfKinCreatedEvent
import seg3x02.pms.domain.patient.events.PatientUpdatedEvent
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.patient.factory.AddressFactory
import seg3x02.pms.domain.patient.factory.ExternalDoctorFactory
import seg3x02.pms.domain.patient.factory.PatientFactory
import seg3x02.pms.domain.patient.factory.PatientNextOfKinFactory
import seg3x02.pms.domain.patient.repositories.AddressRepository
import seg3x02.pms.domain.patient.repositories.ExternalDoctorRepository
import seg3x02.pms.domain.patient.repositories.PatientNextOfKinRepository
import seg3x02.pms.domain.patient.repositories.PatientRepository
import seg3x02.pms.domain.staff.entities.Staff
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class PatientFacadeImpl(
    private val patientRepository: PatientRepository,
    private val patientNextOfKinRepository: PatientNextOfKinRepository,
    private val addressRepository: AddressRepository,
    private val externalDoctorRepository: ExternalDoctorRepository,
    private val patientFactory: PatientFactory,
    private val patientNextOfKinFactory: PatientNextOfKinFactory,
    private val addressFactory: AddressFactory,
    private val externalDoctorFactory: ExternalDoctorFactory,
    private var eventEmitter: DomainEventEmitter,

    ): PatientFacade {
    override fun registerPatient(patient: PatientRegisterDto): String? {
        val accountExist = patientRepository.findById(patient.nas)
        if (accountExist != null) {
            return null
        }
        var patientEntity = patientFactory.createPatient(patient)
        patientEntity = patientRepository.save(patientEntity)
        eventEmitter.emit(PatientCreatedEvent(UUID.randomUUID(), Date(), patientEntity.nas))
        return patientEntity.nas
    }

    override fun createPatientNextOfKin(nextOfKin: PatientNextOfKinRegisterDto): UUID? {
        var patientNextOfKin = patientNextOfKinFactory.createPatientNextOfKin(nextOfKin)
        patientNextOfKin = patientNextOfKinRepository.save(patientNextOfKin)
        eventEmitter.emit(PatientNextOfKinCreatedEvent(UUID.randomUUID(), Date(), patientNextOfKin.id))
        return patientNextOfKinRepository.save(patientNextOfKin).id
    }

    override fun createPatientAddress(address: AddressRegisterDto): UUID? {
        var patientAddress = addressFactory.createAddress(address)
        patientAddress =  addressRepository.save(patientAddress)
        eventEmitter.emit(PatientNextOfKinCreatedEvent(UUID.randomUUID(), Date(), patientAddress.id))
        return addressRepository.save(patientAddress).id
    }

    override fun setPatientNextOfKin(patientNAS: String, patientNextOfKinId: UUID): UUID? {
        val patient = patientRepository.findById(patientNAS)
        if (patient != null) {
            patient.nextOfKin = patientNextOfKinRepository.findById(patientNextOfKinId)!!
            val updatedPatient = patientRepository.save(patient)
            eventEmitter.emit(PatientUpdatedEvent(UUID.randomUUID(), Date(), updatedPatient.nas))
            return updatedPatient.nextOfKin.id
        }
        return null
    }

    override fun setPatientAddress(patientNAS: String, patientAddressId: UUID): UUID? {
        val patient = patientRepository.findById(patientNAS)
        if (patient != null) {
            patient.address = addressRepository.findById(patientAddressId)!!
            val updatedPatient = patientRepository.save(patient)
            eventEmitter.emit(PatientUpdatedEvent(UUID.randomUUID(), Date(), updatedPatient.nas))
            return updatedPatient.address.id
        }
        return null
    }

    override fun setPatientExternalDoctor(patientNaS: String, externalDoctorId: UUID): UUID? {
        val patient = patientRepository.findById(patientNaS)
        if (patient != null) {
            patient.externalDoctor = externalDoctorRepository.findById(externalDoctorId)!!
            val updatedPatient = patientRepository.save(patient)
            eventEmitter.emit(PatientUpdatedEvent(UUID.randomUUID(), Date(), updatedPatient.nas))
            return patient.externalDoctor.id
        }
        return null
    }

    override fun getExternalDoctor(externalDoctorID: UUID): UUID? {
        val externalDoctor = externalDoctorRepository.findById(externalDoctorID)
        if (externalDoctor != null) {
            return externalDoctor.id
        }
        return null
    }
}