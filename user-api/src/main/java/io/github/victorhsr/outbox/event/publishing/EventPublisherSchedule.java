package io.github.victorhsr.outbox.event.publishing;

import io.github.victorhsr.outbox.event.DomainEvent;
import io.github.victorhsr.outbox.event.DomainEventService;
import io.github.victorhsr.outbox.event.publishing.infraestructure.broker.AMQPMessageBroker;
import io.github.victorhsr.outbox.event.publishing.infraestructure.broker.RoutingKeyResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Component
public class EventPublisherSchedule {

    private final Logger LOGGER = LoggerFactory.getLogger(EventPublisherSchedule.class);

    private final DomainEventService domainEventService;
    private final AMQPMessageBroker eventBus;
    private final RoutingKeyResolver routingKeyResolver;

    public EventPublisherSchedule(DomainEventService domainEventService, AMQPMessageBroker eventBus, RoutingKeyResolver routingKeyResolver) {
        this.domainEventService = domainEventService;
        this.eventBus = eventBus;
        this.routingKeyResolver = routingKeyResolver;
    }

    @Scheduled(fixedDelayString = "${event.publisher.rate}")
    public void publishEvents() {

        LOGGER.info("Processing pending messages...");

        this.domainEventService
                .getPendingEvents()
                .stream()
                .map(this::publish)
                .forEach(this.domainEventService::save);
    }

    private DomainEvent publish(final DomainEvent eventToPublish) {

        LOGGER.info("Publishing message: '{}'", eventToPublish);

        this.eventBus.publish(this.routingKeyResolver.resolve(eventToPublish.getEventType()), eventToPublish);
        eventToPublish.markAsPublished();
        return eventToPublish;
    }

}
