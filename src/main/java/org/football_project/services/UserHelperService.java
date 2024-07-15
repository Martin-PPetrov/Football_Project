package org.football_project.services;

import org.football_project.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserHelperService {

    private static final String ROLE_PREFIX = "ROLE_";

    private final UserRepository userRepository;

    public UserHelperService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
