package seg3x02.pms.contracts.testStubs.repositories

import seg3x02.pms.domain.division.entities.Bed
import seg3x02.pms.domain.division.repositories.BedRepository
import seg3x02.pms.domain.patient.entities.patient.Address
import java.util.*

class BedRepositoryStub: BedRepository {
    private val beds: MutableMap<UUID, Bed> = HashMap()
    override fun save(bed: Bed): Bed {
        beds[bed.id] = bed
        return bed
    }

    override fun findById(id: UUID): Bed? {
        return beds[id]
    }

}