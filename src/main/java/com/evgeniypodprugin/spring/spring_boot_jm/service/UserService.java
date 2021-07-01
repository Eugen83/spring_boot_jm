package com.evgeniypodprugin.spring.spring_boot_jm.service;

import com.evgeniypodprugin.spring.spring_boot_jm.model.User;

import java.util.Optional;

public interface UserService {
    void save(User user);
    Iterable<User>getAllUsers();
 //   void updateUser(User user);
    void deleteUser(User user);
    User getUserById(Long id);
}
