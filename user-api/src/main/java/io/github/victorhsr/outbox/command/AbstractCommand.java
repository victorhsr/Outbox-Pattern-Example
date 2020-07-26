package io.github.victorhsr.outbox.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Getter
@AllArgsConstructor
public class AbstractCommand {

    private final String id;
    private final LocalDateTime issuedAt;
    private final Serializable payload;

    public <T> T getPayload() {
        return (T) this.payload;
    }

}
