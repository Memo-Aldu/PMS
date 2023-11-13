package seg3x02.pms.application.services

import seg3x02.pms.domain.common.DomainEvent

/**
 * @author : memo-aldu
 * @mailto : maldu064@uOttawa.ca
 * @created : 11/12/2023, Sunday
 **/
interface DomainEventEmitter {
    fun emit(event: DomainEvent)
}