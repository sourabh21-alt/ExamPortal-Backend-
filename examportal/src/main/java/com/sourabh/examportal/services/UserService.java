package com.sourabh.examportal.services;

import com.sourabh.examportal.entity.User;
import com.sourabh.examportal.entity.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String userName);

    public void deleteUSer(String userName);
}
