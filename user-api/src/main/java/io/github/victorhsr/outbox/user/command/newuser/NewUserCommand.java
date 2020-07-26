package io.github.victorhsr.outbox.user.command.newuser;

import io.github.victorhsr.outbox.command.AbstractCommand;
import io.github.victorhsr.outbox.user.command.newuser.payload.NewUserDTO;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Getter
public class NewUserCommand extends AbstractCommand {

    public NewUserCommand(NewUserDTO newUserDTO) {
        super(UUID.randomUUID().toString(), LocalDateTime.now(), newUserDTO);
    }

}
