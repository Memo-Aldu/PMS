package seg3x02.pms.domain.division.repositories

import seg3x02.pms.domain.division.entities.Division;
import java.util.*

interface DivisionRepository {
    fun findById(id: UUID): Division
    fun save(division: Division): Division
}