package io.github.victorhsr.outbox.user.command.newuser.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.victorhsr.outbox.user.Gender;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author victorhsr <victor.hugo.origins@gmail.com>
 */
@Getter
@Setter
public class NewUserDTO implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("gender")
    private Gender gender;

}
