package com.thoughtworks.capacity.gtb.mvc.Domain;

import com.thoughtworks.capacity.gtb.mvc.Exception.ExceptionMessages;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {
    private int id;

    @NotNull(message = ExceptionMessages.USERNAME_NOT_NULL)
    @NotEmpty(message = ExceptionMessages.USERNAME_NOT_NULL)
    @Pattern(regexp = "^[0-9a-zA-Z_]{3,10}$", message = ExceptionMessages.USERNAME_ILLEGAL)
    private String username;

    @NotNull(message = ExceptionMessages.PASSWORD_NOT_NULL)
    @NotEmpty(message = ExceptionMessages.PASSWORD_NOT_NULL)
    @Size(min = 5, max = 12, message = ExceptionMessages.PASSWORD_ILLEGAL)
    private String password;

    @Email(message = ExceptionMessages.EMAIL_ILLEGAL)
    private String email;

    public User() {
    }
}
