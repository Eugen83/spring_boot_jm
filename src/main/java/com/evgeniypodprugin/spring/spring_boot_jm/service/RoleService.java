package com.evgeniypodprugin.spring.spring_boot_jm.service;

import com.evgeniypodprugin.spring.spring_boot_jm.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    Set<Role> roleById(Long[] role_id);
}
