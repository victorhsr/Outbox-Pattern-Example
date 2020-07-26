package io.github.victorhsr.outbox.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import io.github.victorhsr.outbox.commons.serialization.LocalDateTimeSerializer;
import io.github.victorhsr.outbox.event.publishing.PublishingStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Getter
@Setter
@Entity
@ToString
@Table(name = "t_outbox")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class DomainEvent implements Serializable {

    @Id
    @JsonProperty("id")
    @Column(name = "id")
    private String id;

    @JsonProperty("issued_at")
    @Column(name = "issued_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime issuedAt;

    @JsonProperty("answered_at")
    @Column(name = "answered_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime answeredAt;

    @Type(type = "jsonb")
    @JsonProperty("payload")
    @Column(name = "payload", columnDefinition = "jsonb")
    private Serializable payload;

    @JsonProperty("event_type")
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @JsonIgnore
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PublishingStatus publishingStatus;

    public DomainEvent() {
        this.id = UUID.randomUUID().toString();
        this.answeredAt = LocalDateTime.now();
        this.markAsPending();
    }

    @Builder
    public DomainEvent(LocalDateTime issuedAt, Serializable payload, EventType eventType) {
        this();
        this.issuedAt = issuedAt;
        this.answeredAt = answeredAt;
        this.payload = payload;
        this.eventType = eventType;
    }

    public void markAsPublished() {
        this.publishingStatus = PublishingStatus.PUBLISHED;
    }

    public void markAsPending() {
        this.publishingStatus = PublishingStatus.PENDING;
    }
}
