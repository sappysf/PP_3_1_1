package com.spring_crud.PP_3_1_1.controller;

import com.spring_crud.PP_3_1_1.model.User;
import com.spring_crud.PP_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/add")
    public String createUser(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String department) {
        var user = new User(name, surname, department);
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String department) {
        var user = new User(name, surname, department);
        user.setId(id);
        userService.update(user);
        return "redirect:/";
    }
}
