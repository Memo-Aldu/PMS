package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.division.entities.Room
import seg3x02.pms.domain.division.repositories.RoomRepository
import seg3x02.pms.domain.patient.entities.patient.Patient
import java.util.*

class RoomRepositoryStub: RoomRepository {
    private val rooms: MutableMap<UUID, Room> = HashMap()
    override fun findById(id: UUID): Room? {
        return rooms[id]
    }

    override fun save(room: Room): Room? {
        rooms[room.id] = room
        return room
    }
}