package org.rest_api.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.rest_api.dtos.CompetitionDto;
import org.rest_api.entities.Competition;
import org.rest_api.repositories.CompetitionRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    private final ModelMapper modelMapper;

    public CompetitionDto findCompetitionByName(String name) {
        return competitionRepository.findCompetitionByName(name)
                .map(this::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found"));
    }

    private CompetitionDto mapEntityToDto(Competition competition) {
        return modelMapper.map(competition, CompetitionDto.class);
    }

    public void addCompetition(CompetitionDto competitionDto) {
        Competition competition = modelMapper.map(competitionDto, Competition.class);

        competitionRepository.save(competition);
    }

    public void deleteCompetitionByName(String name) {
        competitionRepository.deleteCompetitionByName(name);
    }

}
