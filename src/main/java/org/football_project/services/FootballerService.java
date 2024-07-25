package org.football_project.services;

import lombok.RequiredArgsConstructor;
import org.football_project.repositories.FootballerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FootballerService {

    private final FootballerRepository footballerRepository;

    private final ModelMapper modelMapper;

    
}
