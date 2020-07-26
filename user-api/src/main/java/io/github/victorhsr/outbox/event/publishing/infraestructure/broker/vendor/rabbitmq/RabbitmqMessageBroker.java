package io.github.victorhsr.outbox.event.publishing.infraestructure.broker.vendor.rabbitmq;

import io.github.victorhsr.outbox.event.DomainEvent;
import io.github.victorhsr.outbox.event.publishing.infraestructure.broker.AMQPMessageBroker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Configuration
public class RabbitmqMessageBroker implements AMQPMessageBroker {

    private final RabbitTemplate rabbitTemplate;

    public RabbitmqMessageBroker(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public DomainEvent publish(final String routingKey, final DomainEvent domainEvent) {

        this.rabbitTemplate.convertAndSend(routingKey, domainEvent);
        return domainEvent;
    }

}
