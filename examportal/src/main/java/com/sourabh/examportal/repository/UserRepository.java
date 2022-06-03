package com.sourabh.examportal.repository;

import com.sourabh.examportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String userName);


    void deleteByUsername(String userName);
}
