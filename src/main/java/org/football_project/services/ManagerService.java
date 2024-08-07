package org.football_project.services;

import lombok.RequiredArgsConstructor;
import org.football_project.dtos.AddManagerDto;
import org.football_project.dtos.ManagerInfoDto;
import org.football_project.entities.Manager;
import org.football_project.repositories.ManagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public List<ManagerInfoDto> getAllManagers() {
        return managerRepository.findAll()
                .stream()
                .map(this::mapToManagerInfoDto)
                .collect(Collectors.toList());
    }

    private ManagerInfoDto mapToManagerInfoDto(Manager manager) {
        return modelMapper.map(manager, ManagerInfoDto.class);
    }

    public void addManager(AddManagerDto addManagerDto) throws IOException {
        Manager manager = modelMapper.map(addManagerDto, Manager.class);

        managerRepository.save(manager);
    }

    @Transactional
    public void deleteManager(String name) {
        managerRepository.deleteManagerByName(name);
    }
}
