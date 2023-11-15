package seg3x02.pms.domain.division.facade.implementation

import seg3x02.pms.application.dtos.queries.PatientAdmissionRequestDto
import seg3x02.pms.application.dtos.queries.PatientAdmissionToDivisionDto
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.enums.BedStatus
import seg3x02.pms.domain.division.enums.DivisionStatus
import seg3x02.pms.domain.division.enums.RoomStatus
import seg3x02.pms.domain.division.facade.DivisionFacade
import seg3x02.pms.domain.division.factory.AdmissionRequestFactory
import seg3x02.pms.domain.division.factory.DivisionFactory
import seg3x02.pms.domain.division.repositories.BedRepository
import seg3x02.pms.domain.patient.repositories.PatientRepository;
import seg3x02.pms.domain.division.repositories.DivisionRepository;
import seg3x02.pms.domain.division.repositories.PatientAdmissionRequestRepository
import seg3x02.pms.domain.division.repositories.RoomRepository
import seg3x02.pms.domain.patient.facade.PatientFacade
import seg3x02.pms.domain.patient.factory.PatientAdmissionFactory
import seg3x02.pms.domain.patient.repositories.PatientAdmissionRepository
import java.util.*

class DivisionFacadeImpl (
    private val divisionRepository: DivisionRepository,
    private val patientAdmissionRepository: PatientAdmissionRepository,
    private val patientAdmissionFactory: PatientAdmissionFactory,
    private val patientAdmissionRequestFactory: AdmissionRequestFactory,
    private val patientAdmissionRequestRepository: PatientAdmissionRequestRepository,
    private val bedRepository: BedRepository,
    private val roomRepository: RoomRepository,

    ) : DivisionFacade {
    override fun admitPatient(admissionRequest: PatientAdmissionToDivisionDto): Boolean {
        val division = divisionRepository.findById(admissionRequest.divisonId)
        val bed = bedRepository.findById(admissionRequest.bedId)
        val room = roomRepository.findById(admissionRequest.roomId)
        if(bed == null || room == null || division == null || bed.bedStatus == BedStatus.TAKEN)
            return false
        val admission = patientAdmissionFactory.createPatientAdmission(admissionRequest)
        patientAdmissionRepository.save(admission)
        bed.setBedStatus(BedStatus.TAKEN)
        bedRepository.save(bed)
        var hasChanged = false
        if(!room.hasAvailableBeds())
            room.setRoomStatus(RoomStatus.COMPLETE)
            roomRepository.save(room)
            hasChanged = true
        if(!hasAvailableRooms(admissionRequest.divisonId) || hasChanged)
            division.setDivisionStatus(DivisionStatus.COMPLETE)
        divisionRepository.save(division)
        
        return true
    }
    override fun requestPatientAdmission(requestDto: PatientAdmissionRequestDto): Boolean {
        val admissionRequestEntity = patientAdmissionRequestFactory.createAdmissionRequest(requestDto)
        patientAdmissionRequestRepository.save(admissionRequestEntity)
        return true

    }
    override fun hasAvailableRooms(divisionId: UUID): Boolean{
        val division = divisionRepository.findById(divisionId)
        return division.rooms.any{ room ->
            room.roomStatus == RoomStatus.NOTCOMPLETE}
    }
    override fun getNotCompleteRooms(divisionId: UUID): List<Room> {
        val division = divisionRepository.findById(divisionId)
        return division.rooms.filter { room ->
            room.roomStatus == RoomStatus.NOTCOMPLETE
        }
    }
    override fun doesDivisionExist(divisionId: UUID): Boolean{
        if(divisionRepository.findById(divisionId) == null)
            return false
        return true
    }
}
