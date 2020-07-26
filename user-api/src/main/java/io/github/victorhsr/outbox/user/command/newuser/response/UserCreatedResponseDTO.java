package io.github.victorhsr.outbox.user.command.newuser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.victorhsr.outbox.user.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Setter
@Getter
@Builder
public class UserCreatedResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("gender")
    private Gender gender;

}
