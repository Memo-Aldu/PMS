package seg3x02.pms.adapters.services.implementation.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import seg3x02.pms.application.services.DomainEventEmitter
import seg3x02.pms.domain.common.DomainEvent

@Component
class DomainEventEmitterAdapter: DomainEventEmitter {
    @Autowired
    private lateinit var applicationEventPublisher: ApplicationEventPublisher

    override fun emit(event: DomainEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}