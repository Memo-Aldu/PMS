package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.division.entities.Division
import seg3x02.pms.domain.division.repositories.DivisionRepository
import java.util.*

class DivisionRepositoryStub: DivisionRepository {
    private val divisions: MutableMap<UUID, Division> = HashMap()
    override fun save(division: Division): Division {
        divisions[division.id] = division
        return division
    }

    override fun findById(id: UUID): Division? {
        return divisions[id]
    }
}