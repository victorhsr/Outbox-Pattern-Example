package io.github.victorhsr.outbox.event.infraestructure;

import io.github.victorhsr.outbox.event.DomainEvent;
import io.github.victorhsr.outbox.event.publishing.PublishingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
public interface DomainEventRepository extends JpaRepository<DomainEvent, String> {

    List<DomainEvent> findByPublishingStatus(final PublishingStatus publishingStatus);

}
