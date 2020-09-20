package com.thoughtworks.capacity.gtb.mvc.Repository;

import com.thoughtworks.capacity.gtb.mvc.Domain.User;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserRepository {
    private final static Set<User> userSet = Collections.synchronizedSet(new HashSet<>());

    public void save(User user) throws UserException {
        if (!userSet.contains(user)) {
            userSet.add(user);
        } else {
            throw new UserException(user.getUsername());
        }
    }
}
