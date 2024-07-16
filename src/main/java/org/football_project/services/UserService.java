package org.football_project.services;

import lombok.RequiredArgsConstructor;
import org.football_project.dtos.UserProfileDto;
import org.football_project.dtos.UserRegisterDTO;
import org.football_project.entities.User;
import org.football_project.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    private final UserHelperService userHelperService;

    //TODO: register method + mapper

    public void register(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO, User.class);

        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(user);
    }

    public UserProfileDto getProfileData() {
        return modelMapper.map(userHelperService.getUser(), UserProfileDto.class);
    }

    public boolean isUsernameUnique(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }

    public boolean isEmailUnique(String email) {
        return !userRepository.existsByEmail(email);
    }
}
