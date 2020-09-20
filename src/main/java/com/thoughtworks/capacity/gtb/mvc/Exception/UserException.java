package com.thoughtworks.capacity.gtb.mvc.Exception;

import org.springframework.http.HttpStatus;

public class UserException extends BasicException {

    public UserException(String userName) {
        super(HttpStatus.CONFLICT, "用户命" + userName + "已存在");
    }

}
