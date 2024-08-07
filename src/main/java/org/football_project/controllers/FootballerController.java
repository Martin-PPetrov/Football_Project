package org.football_project.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.football_project.dtos.AddFootballerDto;
import org.football_project.dtos.FootballerInfoDto;
import org.football_project.services.FootballerService;
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
@RequestMapping("/footballers")
public class FootballerController {

    private final FootballerService footballerService;

    @GetMapping("/view-footballers")
    public String viewFootballers(Model model) {
        List<FootballerInfoDto> footballers = footballerService.getAllFootballers();

        model.addAttribute("allFootballers", footballers);

        return "view-footballers";
    }

    @GetMapping("/add-footballer")
    public ModelAndView addFootballer() {
        ModelAndView modelAndView = new ModelAndView("add-footballer");

        modelAndView.addObject("footballer", new AddFootballerDto());

        return modelAndView;
    }

    @ModelAttribute("footballerData")
    public AddFootballerDto footballerData() {
        return new AddFootballerDto();
    }

    @PostMapping("/add-footballer")
    public String doAddFootballer(
            @Valid AddFootballerDto addFootballerDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) throws IOException {
        footballerService.addFootballer(addFootballerDto);

        return "redirect:/club";
    }

    @ModelAttribute("deleteFootballer")
    public FootballerInfoDto deleteFootballerInfo() {
        return new FootballerInfoDto();
    }

    @GetMapping("/delete-footballer")
    public ModelAndView deleteFootballer() {
        List<FootballerInfoDto> footballers = footballerService.getAllFootballers();

        ModelAndView modelAndView = new ModelAndView("delete-footballer");
        modelAndView.addObject("allFootballers", footballers);

        return modelAndView;
    }

    @DeleteMapping("/delete-footballer/{name}")
    public String deleteFootballer(@PathVariable String name) {
        footballerService.deleteFootballer(name);

        return "redirect:/club";
    }
}
