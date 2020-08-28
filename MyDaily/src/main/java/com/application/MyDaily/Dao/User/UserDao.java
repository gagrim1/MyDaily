package com.application.MyDaily.Dao.User;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.MyDaily.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
