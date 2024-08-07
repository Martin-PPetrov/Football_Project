package org.football_project.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.football_project.dtos.AddManagerDto;
import org.football_project.dtos.ManagerInfoDto;
import org.football_project.services.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/view-managers")
    public String viewManagers(Model model) {
        List<ManagerInfoDto> managers = managerService.getAllManagers();

        model.addAttribute("allManagers", managers);

        return "view-managers";
    }

    @GetMapping("/add-manager")
    public ModelAndView addManager() {
        ModelAndView modelAndView = new ModelAndView("add-manager");

        modelAndView.addObject("manager", new AddManagerDto());

        return modelAndView;
    }

    @ModelAttribute("managerData")
    public AddManagerDto managerData() {
        return new AddManagerDto();
    }

    @PostMapping("/add-manager")
    public String doAddManager(
            @Valid AddManagerDto addManagerDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) throws IOException {
        managerService.addManager(addManagerDto);

        return "redirect:/club";
    }

    @ModelAttribute("deleteManager")
    public ManagerInfoDto deleteManagerInfo() {
        return new ManagerInfoDto();
    }

    @GetMapping("/delete-manager")
    public ModelAndView deleteManager() {
        List<ManagerInfoDto> managers = managerService.getAllManagers();

        ModelAndView modelAndView = new ModelAndView("delete-manager");
        modelAndView.addObject("allManagers", managers);

        return modelAndView;
    }

    @DeleteMapping("/delete-manager/{name}")
    public String deleteManager(@PathVariable String name) {
        managerService.deleteManager(name);

        return "redirect:/club";
    }
}
