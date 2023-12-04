package seg3x02.pms.domain.patient.facade.implementation

import seg3x02.pms.application.dtos.queries.*
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.patient.entities.patient.Address
import seg3x02.pms.domain.patient.entities.patient.ExternalDoctor
import seg3x02.pms.domain.patient.entities.patient.PatientNextOfKin
import seg3x02.pms.domain.patient.events.DischargeCreatedEvent
import seg3x02.pms.domain.patient.events.PatientCreatedEvent
import seg3x02.pms.domain.patient.events.PatientNextOfKinCreatedEvent
import seg3x02.pms.domain.patient.events.PatientUpdatedEvent
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.patient.factory.*
import seg3x02.pms.domain.patient.repositories.*
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
class PatientFacadeImpl(
    private val patientRepository: PatientRepository,
    private val patientAdmissionRepository: PatientAdmissionRepository,
    private val patientNextOfKinRepository: PatientNextOfKinRepository,
    private val dischargeRepository: PatientDischargeRepository,
    private val dischargeFactory: PatientDischargeFactory,
    private val patientFactory: PatientFactory,
    private val externalDoctorFactory: ExternalDoctorFactory,
    private val patientNextOfKinFactory: PatientNextOfKinFactory,
    private val addressFactory: AddressFactory,
    private var eventEmitter: DomainEventEmitter,

    ): PatientFacade {
    override fun registerPatient(patient: PatientRegisterDto): String? {
        val accountExist = patientRepository.findById(patient.nas)
        if (accountExist != null) {
            return null
        }
        val patientNextOfKin: PatientNextOfKin = createNextOfKin(patient.nextOfKin)
        val patientAddress: Address = createAddress(patient.address)
        val externalDoctor: ExternalDoctor = createExternalDoctor(patient.externalDoctor)

        if (patientNextOfKin === null || patientAddress == null || externalDoctor == null) {
            return null
        }
        var patientEntity = patientFactory.createPatient(patient)
        patientEntity.setPatientAddress(patientAddress)
        patientEntity.setPatientNextOfKin(patientNextOfKin)
        patientEntity.setPatientExternalDoctor(externalDoctor)
        patientEntity = patientRepository.save(patientEntity)
        eventEmitter.emit(PatientCreatedEvent(UUID.randomUUID(), Date(), patientEntity.nas))
        return patientEntity.nas
    }

    override fun updatePatientFile(updatedPatient: PatientUpdateDto, patientNAS: String): Boolean {
        var patient = patientRepository.findById(patientNAS)
        if (patient != null) {
            val updated = patientFactory.createPatient(patient, updatedPatient)
            patient.update(updated)
            if (updatedPatient.address != null) {
                val address = createAddress(updatedPatient.address!!)
                patient.setPatientAddress(address)
            }
            if (updatedPatient.nextOfKin != null) {
                val nextOfKin = createNextOfKin(updatedPatient.nextOfKin!!)
                patient.setPatientNextOfKin(nextOfKin)
            }
            if (updatedPatient.externalDoctor != null) {
                val externalDoctor = createExternalDoctor(updatedPatient.externalDoctor)
                patient.setPatientExternalDoctor(externalDoctor)
            }
            patient = patientRepository.save(patient)
            eventEmitter.emit(PatientUpdatedEvent(UUID.randomUUID(), Date(), patient.nas))
            return true
        }
        return false
    }

    override fun addPrescriptionToPatient(patientNAS: String, prescriptionID: UUID): Boolean {
        val patient = patientRepository.findById(patientNAS)
        if (patient != null) {
            patient.addPrescription(prescriptionID)
            patientRepository.save(patient)
            return true
        }
        return false
    }

    override fun dischargePatient(discharge: PatientDischargeDto): UUID? {
        val patientEntity = patientRepository.findById(discharge.patientNAS)
        if (patientEntity != null) {
            var dischargeEntity = dischargeFactory.createPatientDischarge(discharge)
            dischargeEntity = dischargeRepository.save(dischargeEntity)
            eventEmitter.emit(DischargeCreatedEvent(UUID.randomUUID(), Date(), dischargeEntity.id))
            return dischargeEntity.id
        }
        return null
    }

    private fun createAddress(address: AddressRegisterDto): Address {
        return addressFactory.createAddress(address)
    }

    private fun createExternalDoctor(externalDoctor: ExternalDoctorDto): ExternalDoctor {
        return externalDoctorFactory.createExternalDoctor(externalDoctor)
    }

    private fun createNextOfKin(nextOfKin: PatientNextOfKinRegisterDto): PatientNextOfKin {
        var patientNextOfKin = patientNextOfKinFactory.createPatientNextOfKin(nextOfKin)
        patientNextOfKin = patientNextOfKinRepository.save(patientNextOfKin)
        eventEmitter.emit(PatientNextOfKinCreatedEvent(UUID.randomUUID(), Date(), patientNextOfKin.id))
        return patientNextOfKin;
    }
    override fun isPatientAdmitted(patientNAS: String): Boolean {
        val p = patientAdmissionRepository.findByPatientNAS(patientNAS)
        if (p != null)
            return true
        return false
    }
    override fun doesPatientExist(patientNAS: String): Boolean{
        if(patientRepository.findById(patientNAS) == null)
            return false
        return true
    }
}
