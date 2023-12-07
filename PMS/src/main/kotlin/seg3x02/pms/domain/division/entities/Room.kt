package seg3x02.pms.domain.division.entities

import seg3x02.pms.domain.division.enums.BedStatus
import seg3x02.pms.domain.division.enums.RoomStatus
import java.util.*

class Room(
    val id: UUID,
)
{
    var roomStatus: RoomStatus = RoomStatus.NOT_COMPLETE
        private set
    var beds: MutableList<Bed> = ArrayList()
    fun hasAvailableBeds(): Boolean {
        return beds.any { bed ->
            bed.bedStatus == BedStatus.AVAILABLE
        }
    }
    fun setRoomStatus(status: RoomStatus){
        this.roomStatus = status
    }
}