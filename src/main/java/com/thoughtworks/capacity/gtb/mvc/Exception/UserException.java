package com.thoughtworks.capacity.gtb.mvc.Exception;

import org.springframework.http.HttpStatus;

public class UserException extends Exception {
    private String message;
    private final HttpStatus httpStatus;

    public UserException(HttpStatus httpStatus, String userName) {
        this.message = "用户名" + userName + "已存在";
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
