package org.football_project.controllers;

import lombok.RequiredArgsConstructor;
import org.football_project.dtos.AddFootballerDto;
import org.football_project.services.FootballerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/footballers")
public class FootballerController {

    private final FootballerService footballerService;

    @GetMapping
    public ModelAndView addFootballer() {
        ModelAndView modelAndView = new ModelAndView("add-footballer");

        modelAndView.addObject("footballer", new AddFootballerDto());

        return modelAndView;
    }
}
