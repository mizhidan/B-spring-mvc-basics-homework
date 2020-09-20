package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserException;
import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) throws UserException {
        userRepository.save(user);
    }
}
