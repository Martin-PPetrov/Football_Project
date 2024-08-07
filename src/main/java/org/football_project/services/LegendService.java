package org.football_project.services;

import lombok.RequiredArgsConstructor;
import org.football_project.dtos.AddLegendDto;
import org.football_project.dtos.LegendInfoDto;
import org.football_project.entities.Legend;
import org.football_project.repositories.LegendRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LegendService {

    private final LegendRepository legendRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public List<LegendInfoDto> getAllLegends() {
        return legendRepository.findAll()
                .stream()
                .map(this::mapToLegendInfoDto)
                .collect(Collectors.toList());
    }

    private LegendInfoDto mapToLegendInfoDto(Legend legend) {
        return modelMapper.map(legend, LegendInfoDto.class);
    }

    public void addLegend(AddLegendDto AddLegendDto) throws IOException {
        Legend legend = modelMapper.map(AddLegendDto, Legend.class);

        legendRepository.save(legend);
    }

    @Transactional
    public void deleteLegend(String name) {
        legendRepository.deleteLegendByName(name);
    }
}
