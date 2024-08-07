package org.football_project.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.football_project.dtos.AddLegendDto;
import org.football_project.dtos.LegendInfoDto;
import org.football_project.services.LegendService;
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
@RequestMapping("/legends")
public class LegendController {

    private final LegendService legendService;

    @GetMapping("/view-legends")
    public String viewLegends(Model model) {
        List<LegendInfoDto> legends = legendService.getAllLegends();

        model.addAttribute("allLegends", legends);

        return "view-legends";
    }

    @GetMapping("/add-legend")
    public ModelAndView addLegend() {
        ModelAndView modelAndView = new ModelAndView("add-legend");

        modelAndView.addObject("legend", new AddLegendDto());

        return modelAndView;
    }

    @ModelAttribute("legendData")
    public AddLegendDto legendData() {
        return new AddLegendDto();
    }

    @PostMapping("/add-legend")
    public String doAddLegend(
            @Valid AddLegendDto addLegendDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) throws IOException {
        legendService.addLegend(addLegendDto);

        return "redirect:/club";
    }

    @ModelAttribute("deleteLegend")
    public LegendInfoDto deleteLegendInfo() {
        return new LegendInfoDto();
    }

    @GetMapping("/delete-legend")
    public ModelAndView deleteLegend() {
        List<LegendInfoDto> legends = legendService.getAllLegends();

        ModelAndView modelAndView = new ModelAndView("delete-legend");
        modelAndView.addObject("allLegends", legends);

        return modelAndView;
    }

    @DeleteMapping("/delete-legend/{name}")
    public String deleteLegend(@PathVariable String name) {
        legendService.deleteLegend(name);

        return "redirect:/club";
    }

}
