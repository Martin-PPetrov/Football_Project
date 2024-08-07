package org.rest_api.controllers;

import lombok.RequiredArgsConstructor;
import org.rest_api.dtos.CompetitionDto;
import org.rest_api.services.CompetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    @GetMapping("/find/{name}")
    public ResponseEntity<CompetitionDto> findCompetitionByName(@PathVariable String name) {
        return ResponseEntity.ok(competitionService.findCompetitionByName(name));
    }

    @PostMapping("/add-competition")
    public void addCompetition(@RequestBody CompetitionDto competitionDto) {
        competitionService.addCompetition(competitionDto);
    }

    @DeleteMapping("/delete-competition/{name}")
    public void deleteCompetitionByName(@PathVariable String name) {
        competitionService.deleteCompetitionByName(name);
    }

}
