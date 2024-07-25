package org.football_project.controllers;

import lombok.RequiredArgsConstructor;
import org.football_project.services.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ClubService clubService;

    @GetMapping
    public String club() {
        return "club";
    }

}
