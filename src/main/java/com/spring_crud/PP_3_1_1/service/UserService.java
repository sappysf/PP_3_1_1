package com.spring_crud.PP_3_1_1.service;

import com.spring_crud.PP_3_1_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(Long id);
    void update(User user);
}
