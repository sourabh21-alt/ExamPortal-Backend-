package com.sourabh.examportal.controller;

import com.sourabh.examportal.entity.Role;
import com.sourabh.examportal.entity.User;
import com.sourabh.examportal.entity.UserRole;
import com.sourabh.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName) {

        return this.userService.getUser(userName);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        // here we assuming that only normal users are registering;
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles =new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);
        return userService.createUser(user,roles);
    }

    @DeleteMapping("/{userName}")
    public void deleteUser(@PathVariable String userName) {
        this.userService.deleteUSer(userName);
    }
}
