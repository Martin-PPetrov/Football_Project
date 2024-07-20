package org.football_project.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.football_project.dtos.UserRegisterDTO;
import org.football_project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/register")
    public String doRegister(
            @Valid UserRegisterDTO userRegisterDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);

            return "redirect:register";
        }

        userService.register(userRegisterDTO);

        return "redirect:/users/login";
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("profile");

        modelAndView.addObject("profileData", userService.getProfileData());

        return modelAndView;
    }
}
