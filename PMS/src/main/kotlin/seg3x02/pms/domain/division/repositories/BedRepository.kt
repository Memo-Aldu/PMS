package seg3x02.pms.domain.division.repositories

import seg3x02.pms.domain.division.entities.Bed
import java.util.*

interface BedRepository {
    fun findById(id: UUID): Bed
    fun save(bed: Bed): Bed
}