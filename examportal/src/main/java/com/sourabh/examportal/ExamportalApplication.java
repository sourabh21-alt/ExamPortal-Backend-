package com.sourabh.examportal;

import com.sourabh.examportal.entity.Role;
import com.sourabh.examportal.entity.User;
import com.sourabh.examportal.entity.UserRole;
import com.sourabh.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class   ExamportalApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// it run only once to add admin
//		User user = new User();
//		user.setFirstName("sourabh");
//		user.setLastName("sanghi");
//		user.setUsername("sourabh123");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setEmail("sanghi@gmail.com");
//		user.setProfile("default.png");
//
//		Role role = new Role();
//		role.setRoleId(44);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user,userRoleSet);

	}

}
