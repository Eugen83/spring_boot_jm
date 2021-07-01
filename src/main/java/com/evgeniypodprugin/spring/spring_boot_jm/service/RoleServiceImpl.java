package com.evgeniypodprugin.spring.spring_boot_jm.service;

import com.evgeniypodprugin.spring.spring_boot_jm.model.Role;
import com.evgeniypodprugin.spring.spring_boot_jm.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role> roleIterable = roleRepository.findAll();
        Set<Role> roleSet = new HashSet<>();
        roleIterable.forEach(roleSet::add);
        return roleSet;
    }

    @Override
    public Set<Role> roleById(Long[] role_id) {
        Set<Role> roleResult = new HashSet<>();
        for (Long id : role_id) {
            Optional<Role> result = roleRepository.findById(id);
            if (result.isPresent()) {
                roleResult.add(result.get());
            }
        }
        return roleResult;
    }

}
