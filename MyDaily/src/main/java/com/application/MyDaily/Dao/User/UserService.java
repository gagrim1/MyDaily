package com.application.MyDaily.Dao.User;

import java.util.List;

import com.application.MyDaily.model.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    List<User> findAll();
    void deleteUser(Long id);
}
