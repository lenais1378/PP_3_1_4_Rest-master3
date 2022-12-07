package ru.kata.spring.boot_security.service;

import ru.kata.spring.boot_security.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    Role findById(long role_id);

    List<Role> findAll();
}
