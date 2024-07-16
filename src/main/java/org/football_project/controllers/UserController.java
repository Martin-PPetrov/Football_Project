package org.football_project.controllers;

import lombok.RequiredArgsConstructor;
import org.football_project.dtos.UserRegisterDTO;
import org.football_project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String viewRegister(Model model) {
        if (!model.containsAttribute("registerData")) {
            model.addAttribute("registerData", new UserRegisterDTO());
        }

        return "register";
    }

//    @PostMapping("/register")
//    public String doRegister() {
//        //TODO
//    }
}
