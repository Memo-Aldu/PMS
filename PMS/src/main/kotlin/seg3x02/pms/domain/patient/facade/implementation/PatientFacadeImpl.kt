package seg3x02.pms.domain.patient.facade.implementation

import seg3x02.pms.application.dtos.queries.AddressRegisterDto
import seg3x02.pms.application.dtos.queries.PatientNextOfKinRegisterDto
import seg3x02.pms.application.dtos.queries.PatientRegisterDto
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.events.PatientCreatedEvent
import seg3x02.pms.domain.patient.events.PatientNextOfKinCreatedEvent
import seg3x02.pms.domain.patient.events.PatientUpdatedEvent
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.patient.factory.AddressFactory
import seg3x02.pms.domain.patient.factory.PatientFactory
import seg3x02.pms.domain.patient.factory.PatientNextOfKinFactory
import seg3x02.pms.domain.patient.repositories.AddressRepository
import seg3x02.pms.domain.patient.repositories.PatientNextOfKinRepository
import seg3x02.pms.domain.patient.repositories.PatientRepository
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
    private val patientFactory: PatientFactory,
    private val patientNextOfKinFactory: PatientNextOfKinFactory,
    private val addressFactory: AddressFactory,
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

    override fun createPatientNextOfKin(nextOfKin: PatientNextOfKinRegisterDto): PatientNextOfKin? {
        var patientNextOfKin = patientNextOfKinFactory.createPatientNextOfKin(nextOfKin)
        patientNextOfKin = patientNextOfKinRepository.save(patientNextOfKin)
        eventEmitter.emit(PatientNextOfKinCreatedEvent(UUID.randomUUID(), Date(), patientNextOfKin.id))
        return patientNextOfKinRepository.save(patientNextOfKin)
    }

    override fun createPatientAddress(address: AddressRegisterDto): Address? {
        var patientAddress = addressFactory.createAddress(address)
        patientAddress =  addressRepository.save(patientAddress)
        eventEmitter.emit(PatientNextOfKinCreatedEvent(UUID.randomUUID(), Date(), patientAddress.id))
        return addressRepository.save(patientAddress)
    }

    override fun setPatientNextOfKin(patientNAS: String, patientNextOfKin: PatientNextOfKin): UUID? {
        val patient = patientRepository.findById(patientNAS)
        if (patient != null) {
            patient.nextOfKin = patientNextOfKin
            val updatedPatient = patientRepository.save(patient)
            eventEmitter.emit(PatientUpdatedEvent(UUID.randomUUID(), Date(), updatedPatient.nas))
            return patientNextOfKin.id
        }
        return null
    }

    override fun setPatientAddress(patientNAS: String, patientAddress: Address): UUID? {
        val patient = patientRepository.findById(patientNAS)
        if (patient != null) {
            patient.address = patientAddress
            val updatedPatient = patientRepository.save(patient)
            eventEmitter.emit(PatientUpdatedEvent(UUID.randomUUID(), Date(), updatedPatient.nas))
            return patientAddress.id
        }
        return null
    }
}