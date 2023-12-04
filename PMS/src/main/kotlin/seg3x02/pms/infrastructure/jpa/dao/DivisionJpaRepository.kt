package seg3x02.pms.infrastructure.jpa.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import seg3x02.pms.infrastructure.jpa.entities.division.DivisionJpaEntity
import java.util.*

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 12/3/2023, Sunday
 **/

@Repository
interface DivisionJpaRepository: CrudRepository<DivisionJpaEntity, UUID> {
}