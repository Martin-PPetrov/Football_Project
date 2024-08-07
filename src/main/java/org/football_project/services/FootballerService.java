package org.football_project.services;

import lombok.RequiredArgsConstructor;
import org.football_project.dtos.AddFootballerDto;
import org.football_project.dtos.FootballerInfoDto;
import org.football_project.entities.Footballer;
import org.football_project.repositories.FootballerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FootballerService {

    private final FootballerRepository footballerRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public List<FootballerInfoDto> getAllFootballers() {
        return footballerRepository.findAll()
                .stream()
                .map(this::mapToFootballerInfoDto)
                .collect(Collectors.toList());
    }

    private FootballerInfoDto mapToFootballerInfoDto(Footballer footballer) {
        return modelMapper.map(footballer, FootballerInfoDto.class);
    }

    public void addFootballer(AddFootballerDto addFootballerDto) throws IOException {
        //TODO: add picture of footballer

        Footballer footballer = modelMapper.map(addFootballerDto, Footballer.class);

        footballerRepository.save(footballer);
    }

    @Transactional
    public void deleteFootballer(String name) {
        footballerRepository.deleteFootballerByName(name);
    }
}
