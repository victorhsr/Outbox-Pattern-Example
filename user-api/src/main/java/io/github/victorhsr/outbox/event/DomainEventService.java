package io.github.victorhsr.outbox.event;

import io.github.victorhsr.outbox.event.infraestructure.DomainEventRepository;
import io.github.victorhsr.outbox.event.publishing.PublishingStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Service
public class DomainEventService {

    private final DomainEventRepository domainEventRepository;

    public DomainEventService(DomainEventRepository domainEventRepository) {
        this.domainEventRepository = domainEventRepository;
    }

    public DomainEvent save(final DomainEvent domainEvent) {
        return this.domainEventRepository.save(domainEvent);
    }

    public List<DomainEvent> getPendingEvents() {
        return this.domainEventRepository.findByPublishingStatus(PublishingStatus.PENDING);
    }
}
