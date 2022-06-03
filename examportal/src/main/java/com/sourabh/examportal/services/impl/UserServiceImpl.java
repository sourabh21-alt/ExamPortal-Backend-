package com.sourabh.examportal.services.impl;

import com.sourabh.examportal.entity.User;
import com.sourabh.examportal.entity.UserRole;
import com.sourabh.examportal.repository.RoleRepository;
import com.sourabh.examportal.repository.UserRepository;
import com.sourabh.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
 class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = userRepository.findByUsername(user.getUsername());
        if(local!=null) {
            System.out.println("User is already there!!");
            throw new Exception("user already exist");
        } else {
            for( UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
             local = userRepository.save(user);

        }
        return local;

    }

    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUsername(userName);
    }

    @Override
    @Transactional
    public void deleteUSer(String userName) {
        this.userRepository.deleteByUsername(userName);
    }
}
