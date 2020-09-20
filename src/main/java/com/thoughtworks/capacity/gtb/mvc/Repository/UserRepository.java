package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {
    private final static Map<String, User> userMap = new LinkedHashMap<>();

    private final static AtomicInteger nextId = new AtomicInteger(1);

    public void save(User user) throws UserException {
        if (!userMap.containsKey(user.getUsername())) {
            user.setId(nextId.get());
            userMap.put(user.getUsername(), user);
            nextId.set(nextId.get() + 1);
        } else {
            throw new UserException(user.getUsername());
        }
    }

    public User findByUsername(String username) {
        return userMap.get(username);
    }
}
