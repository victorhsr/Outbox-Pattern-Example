package io.github.victorhsr.outbox.event.publishing.infraestructure.broker;

import io.github.victorhsr.outbox.event.EventType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RoutingKeyResolver {

    private final Map<EventType, String> eventTypeToRoutingKeyMap;

    public RoutingKeyResolver(@Value("${user.event.queue.user-created}") final String userCreatedRoute) {

        this.eventTypeToRoutingKeyMap = new HashMap<>();
        this.eventTypeToRoutingKeyMap.put(EventType.USER_CREATED, userCreatedRoute);
    }

    public String resolve(final EventType eventType) {

        if (!eventTypeToRoutingKeyMap.containsKey(eventType)) {
            throw new IllegalArgumentException("Unmapped event type");
        }

        return this.eventTypeToRoutingKeyMap.get(eventType);
    }
}
