package seg3x02.pms.domain.division.facade.implementation

import seg3x02.pms.application.dtos.queries.PatientAdmissionFormRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.division.entities.AdmissionRequest
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.enums.BedStatus
import seg3x02.pms.domain.division.enums.DivisionStatus
import seg3x02.pms.domain.division.enums.RoomStatus
import seg3x02.pms.domain.division.events.PatientRequestAdmissionCreatedEvent
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.division.factory.PatientAdmissionRequestFactory
import seg3x02.pms.domain.division.repositories.BedRepository
import seg3x02.pms.domain.division.repositories.DivisionRepository;
import seg3x02.pms.domain.division.repositories.PatientAdmissionRequestRepository
import seg3x02.pms.domain.division.repositories.RoomRepository
import seg3x02.pms.domain.patient.events.DischargeCreatedEvent
import seg3x02.pms.domain.patient.events.PatientAdmissionCreatedEvent
import seg3x02.pms.domain.patient.factory.PatientAdmissionFactory
import seg3x02.pms.domain.patient.repositories.PatientAdmissionRepository
import java.util.*

class DivisionFacadeImpl(
    private val divisionRepository: DivisionRepository,
    private val patientAdmissionRepository: PatientAdmissionRepository,
    private val patientAdmissionRequestFactory: PatientAdmissionRequestFactory,
    private val patientAdmissionFactory: PatientAdmissionFactory,
    private val patientAdmissionRequestRepository: PatientAdmissionRequestRepository,
    private val bedRepository: BedRepository,
    private val roomRepository: RoomRepository,
    private var eventEmitter: DomainEventEmitter,

    ) : DivisionFacade {
    override fun admitPatient(patientAdmission: PatientAdmissionToDivisionDto): Boolean {
        val division = divisionRepository.findById(patientAdmission.divisonId)
        val bed = bedRepository.findById(patientAdmission.bedId)
        val room = roomRepository.findById(patientAdmission.roomId)
        if(bed == null || room == null || division == null || bed.bedStatus == BedStatus.TAKEN)
            return false
        val admission = patientAdmissionFactory.createPatientAdmission(patientAdmission)
        patientAdmissionRepository.save(admission)
        bed.setBedStatus(BedStatus.TAKEN)
        bedRepository.save(bed)
        if(!room.hasAvailableBeds())
            room.setRoomStatus(RoomStatus.COMPLETE)
            roomRepository.save(room)
        if(!hasAvailableRooms(patientAdmission.divisonId)!! )
            division.setDivisionStatus(DivisionStatus.COMPLETE)
        divisionRepository.save(division)
        eventEmitter.emit(PatientAdmissionCreatedEvent(UUID.randomUUID(), Date(), patientAdmission.patientNAS))
        return true
    }

    override fun admitPatient(admissionFormRequest: PatientAdmissionFormRequestDto): Boolean {
        val request: AdmissionRequest = patientAdmissionRequestRepository.findById(admissionFormRequest.requestId)
            ?: return false
        val division = divisionRepository.findById(request.divisionId)
        val bed = bedRepository.findById(admissionFormRequest.bedId)
        val room = roomRepository.findById(admissionFormRequest.roomId)
        if(bed == null || room == null || division == null || bed.bedStatus == BedStatus.TAKEN)
            return false
        val admission = patientAdmissionFactory.createPatientAdmission(admissionFormRequest, request)
        patientAdmissionRepository.save(admission)
        bed.setBedStatus(BedStatus.TAKEN)
        bedRepository.save(bed)
        if(!room.hasAvailableBeds())
            room.setRoomStatus(RoomStatus.COMPLETE)
        roomRepository.save(room)
        if(!hasAvailableRooms(request.divisionId)!! )
            division.setDivisionStatus(DivisionStatus.COMPLETE)
        divisionRepository.save(division)
        return true
    }

    override fun requestPatientAdmission(admissionRequest: PatientAdmissionRequestDto): Boolean {
        val division = divisionRepository.findById(admissionRequest.divisionId)
        val admissionRequestEntity = patientAdmissionRequestFactory.createPatientAdmissionRequest(admissionRequest)
        patientAdmissionRequestRepository.save(admissionRequestEntity)
        division?.addPatientAdmissionRequest(admissionRequest.patientNAS)
        eventEmitter.emit(PatientRequestAdmissionCreatedEvent(UUID.randomUUID(), Date(), admissionRequest.patientNAS))

        return true

    }
    override fun hasAvailableRooms(divisionId: UUID): Boolean? {
        val division = divisionRepository.findById(divisionId)
        return division?.rooms?.any{ room ->
            room.roomStatus == RoomStatus.NOT_COMPLETE}
    }
    override fun getNotCompleteRooms(divisionId: UUID): List<Room>? {
        val division = divisionRepository.findById(divisionId)
        return division?.rooms?.filter { room ->
            room.roomStatus == RoomStatus.NOT_COMPLETE
        }
    }
    override fun doesDivisionExist(divisionId: UUID): Boolean{
        return divisionRepository.findById(divisionId) != null
    }

    override fun doesAdmissionRequestExist(requestId: UUID): Boolean {
        return patientAdmissionRequestRepository.findById(requestId) != null
    }

    override fun getDivision(divisionId: UUID): Division? {
        return divisionRepository.findById(divisionId)
    }
}
