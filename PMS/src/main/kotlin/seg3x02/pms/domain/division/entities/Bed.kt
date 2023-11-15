package seg3x02.pms.domain.division.entities
import seg3x02.pms.domain.division.enums.BedStatus
import seg3x02.pms.domain.division.enums.RoomStatus
import java.util.*

class Bed(
    val id: UUID,

)
{
    lateinit var bedStatus: BedStatus
    fun setBedStatus(status: BedStatus){
        this.bedStatus = status
    }
}