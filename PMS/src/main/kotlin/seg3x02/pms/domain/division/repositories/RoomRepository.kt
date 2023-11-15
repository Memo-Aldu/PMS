package seg3x02.pms.domain.division.repositories

import seg3x02.pms.domain.division.entities.Room
import java.util.*

interface RoomRepository {
    fun findById(id: UUID): Room
    fun save(room: Room): Room
}