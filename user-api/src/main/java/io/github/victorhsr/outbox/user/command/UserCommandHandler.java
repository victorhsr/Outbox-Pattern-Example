package io.github.victorhsr.outbox.user.command;

import io.github.victorhsr.outbox.commons.ObjectParser;
import io.github.victorhsr.outbox.event.DomainEvent;
import io.github.victorhsr.outbox.event.DomainEventService;
import io.github.victorhsr.outbox.event.EventType;
import io.github.victorhsr.outbox.user.User;
import io.github.victorhsr.outbox.user.command.newuser.NewUserCommand;
import io.github.victorhsr.outbox.user.command.newuser.payload.NewUserDTO;
import io.github.victorhsr.outbox.user.infraestructure.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Service
public class UserCommandHandler {

    private final ObjectParser<NewUserDTO, User> newUserToUserParser;
    private final UserRepository userRepository;
    private final DomainEventService domainEventService;

    public UserCommandHandler(ObjectParser<NewUserDTO, User> newUserToUserParser, UserRepository userRepository, DomainEventService domainEventService) {
        this.newUserToUserParser = newUserToUserParser;
        this.userRepository = userRepository;
        this.domainEventService = domainEventService;
    }

    @Transactional
    public User handleNewUser(final NewUserCommand newUserCommand) {

        final User user = this.newUserToUserParser.parse(newUserCommand.getPayload());

        // apply some busines logic, encripty password, etc (...)

        final User persistedUser = this.userRepository.save(user);
        final DomainEvent userCreatedEvent = DomainEvent
                .builder()
                .issuedAt(newUserCommand.getIssuedAt())
                .payload(persistedUser)
                .eventType(EventType.USER_CREATED)
                .build();

        this.domainEventService.save(userCreatedEvent);
        return persistedUser;
    }

}
