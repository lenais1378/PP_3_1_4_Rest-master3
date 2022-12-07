package ru.kata.spring.boot_security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.model.Role;
import ru.kata.spring.boot_security.model.User;
import ru.kata.spring.boot_security.service.RoleService;
import ru.kata.spring.boot_security.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        roleService.addRole(role1);
        roleService.addRole(role2);

        Set<Role> roleAdmin = new HashSet<>();
        Set<Role> roleUser = new HashSet<>();

        roleAdmin.add(role1);
        roleUser.add(role2);

        User user1 = new User("admin", "admin", 12, "ad@min", 1000000, "admin", "admin", roleAdmin);
        User user2 = new User("user", "user", 15, "us@er", 121030, "user", "user", roleUser);

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
