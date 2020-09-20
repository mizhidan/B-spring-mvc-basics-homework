package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserException;
import com.thoughtworks.capacity.gtb.mvc.Service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody User user) throws UserException {
        loginService.register(user);
    }
}
