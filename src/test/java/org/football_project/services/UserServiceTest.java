package org.football_project.services;

import org.football_project.dtos.UserRegisterDTO;
import org.football_project.entities.User;
import org.football_project.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserHelperService userHelperService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, passwordEncoder, new ModelMapper(), userHelperService);
    }

    @Test
    void testUserRegistration() {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setFirstName("user");
        userRegisterDTO.setLastName("user");
        userRegisterDTO.setPassword("password");
        userRegisterDTO.setEmail("user@email");

        when(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .thenReturn(userRegisterDTO.getPassword());

        userService.register(userRegisterDTO);

        verify(userRepository).save(userArgumentCaptor.capture());

        User user = userArgumentCaptor.getValue();

        Assertions.assertNotNull(user);
        Assertions.assertEquals(userRegisterDTO.getFirstName(), user.getFirstName());
        Assertions.assertEquals(userRegisterDTO.getLastName(), user.getLastName());
        Assertions.assertEquals(userRegisterDTO.getPassword(), user.getPassword());
        Assertions.assertEquals(userRegisterDTO.getEmail(), user.getEmail());
    }

}
