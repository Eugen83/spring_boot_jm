package com.evgeniypodprugin.spring.spring_boot_jm.controller;

import com.evgeniypodprugin.spring.spring_boot_jm.model.User;
import com.evgeniypodprugin.spring.spring_boot_jm.service.RoleService;
import com.evgeniypodprugin.spring.spring_boot_jm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ModelAndView allUsers() {
        List<User> users = new ArrayList<>();
        userService.getAllUsers().forEach(users::add);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }


    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("rolelist", roleService.getAllRoles());
        return modelAndView;
    }

    @PostMapping("")
    public String addUser(@ModelAttribute User user,
                          @RequestParam(defaultValue = "2", required = false, name = "role_id") Long [] role_id
     ){
        user.setRoles(roleService.roleById(role_id));
        userService.save(user);
        return "redirect:/admin";
    }


    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("user", userService.getUserById(id));
        modelAndView.addObject("rolelist", roleService.getAllRoles());
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute User user,
                             @RequestParam(required = false, name = "role_id") Long [] role_id) {
        user.setRoles(roleService.roleById(role_id));
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/admin";
    }

}
