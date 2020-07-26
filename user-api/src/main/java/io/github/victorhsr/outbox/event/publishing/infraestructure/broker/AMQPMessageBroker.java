package io.github.victorhsr.outbox.event.publishing.infraestructure.broker;

import io.github.victorhsr.outbox.event.DomainEvent;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
public interface AMQPMessageBroker {

    DomainEvent publish(final String routingKey, final DomainEvent domainEvent);

}
