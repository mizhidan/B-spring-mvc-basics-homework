package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserException;
import com.thoughtworks.capacity.gtb.mvc.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) throws UserException {
        userRepository.save(user);
    }

    public User login(String username, String password) throws UserException {
        if (!Pattern.matches("(\\w){3,10}", username)) {
            throw new UserException("用户名长度需要在3-10之间");
        }
        if (!Pattern.matches(".{5,12}", password)) {
            throw new UserException("密码长度需要在5-12之间");
        }
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserException("用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new UserException("密码错误");
        }
        return user;
    }
}
