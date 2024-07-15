package org.football_project.services;

import lombok.RequiredArgsConstructor;
import org.football_project.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserHelperService userHelperService;

    //TODO: register method + mapper
}
