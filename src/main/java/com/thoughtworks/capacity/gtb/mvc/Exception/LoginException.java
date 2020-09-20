package com.thoughtworks.capacity.gtb.mvc.Exception;

import org.springframework.http.HttpStatus;

public class LoginException extends BasicException {

    public LoginException(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
