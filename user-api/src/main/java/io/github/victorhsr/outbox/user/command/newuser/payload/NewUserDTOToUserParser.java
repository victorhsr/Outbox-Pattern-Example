package io.github.victorhsr.outbox.user.command.newuser.payload;

import io.github.victorhsr.outbox.commons.ObjectParser;
import io.github.victorhsr.outbox.user.User;
import org.springframework.stereotype.Component;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Component
public class NewUserDTOToUserParser implements ObjectParser<NewUserDTO, User> {

    @Override
    public User parse(final NewUserDTO input) {

        final User user = User
                .builder()
                .email(input.getEmail())
                .name(input.getName())
                .gender(input.getGender())
                .password(input.getPassword())
                .build();

        return user;
    }
}
