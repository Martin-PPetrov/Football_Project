package org.football_project.services;

import org.football_project.entities.Role;
import org.football_project.entities.User;
import org.football_project.entities.enums.UserRoleEnum;
import org.football_project.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserHelperServiceTest {

    private static final String USERNAME = "username";

    private static final String NON_EXISTENT_USERNAME = "noUsername";

    private AppUserDetailsService appUserDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        appUserDetailsService = new AppUserDetailsService(userRepository);
    }

    @Test
    void testLoadUserByUsername_UserFound() {
        User user = new User();
        user.setUsername("username");
        user.setFirstName("user");
        user.setLastName("user");
        user.setPassword("password");
        user.setEmail("user@email");

        Role role = new Role();
        role.setName(UserRoleEnum.USER);
        user.setRoles(Set.of(role));

        when(userRepository.findByUsername(USERNAME))
                .thenReturn(Optional.of(user));

        UserDetails userDetails = appUserDetailsService.loadUserByUsername(USERNAME);

        Assertions.assertInstanceOf(UserDetails.class, userDetails);

        Assertions.assertEquals(user.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(user.getPassword(), userDetails.getPassword());

        var expectedRoles = user.getRoles()
                .stream().map(Role::getName)
                .map(entity -> "ROLE_" + entity)
                .toList();
        var actualRoles = userDetails.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .toList();

        Assertions.assertEquals(expectedRoles, actualRoles);
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> appUserDetailsService.loadUserByUsername(NON_EXISTENT_USERNAME)
        );
    }

}
