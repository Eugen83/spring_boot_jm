package com.evgeniypodprugin.spring.spring_boot_jm.repository;

import com.evgeniypodprugin.spring.spring_boot_jm.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

}
