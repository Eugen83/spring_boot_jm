package com.evgeniypodprugin.spring.spring_boot_jm.repository;

import com.evgeniypodprugin.spring.spring_boot_jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
