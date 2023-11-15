package seg3x02.pms.domain.division.entities
import seg3x02.pms.domain.division.enums.BedStatus
import seg3x02.pms.domain.division.enums.RoomStatus
import java.util.*
import kotlin.properties.Delegates

class Bed(
    val id: UUID,

)
{
    var bedStatus: BedStatus = BedStatus.AVAILABLE
        private set
    fun setBedStatus(status: BedStatus) {
        this.bedStatus = status
    }
}