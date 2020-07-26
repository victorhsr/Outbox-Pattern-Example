package io.github.victorhsr.outbox.user.command.newuser.response;

import io.github.victorhsr.outbox.commons.ObjectParser;
import io.github.victorhsr.outbox.user.User;
import org.springframework.stereotype.Component;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Component
public class UserToUserCreatedDTOParser implements ObjectParser<User, UserCreatedResponseDTO> {

    @Override
    public UserCreatedResponseDTO parse(final User input) {

        final UserCreatedResponseDTO userCreatedResponseDTO = UserCreatedResponseDTO
                .builder()
                .id(input.getId())
                .email(input.getEmail())
                .gender(input.getGender())
                .name(input.getName())
                .build();

        return userCreatedResponseDTO;
    }
}
