package org.football_project.config;

import lombok.RequiredArgsConstructor;
import org.football_project.entities.Role;
import org.football_project.entities.User;
import org.football_project.entities.enums.UserRoleEnum;
import org.football_project.repositories.RoleRepository;
import org.football_project.repositories.UserRepository;
import org.football_project.services.AppUserDetailsService;
import org.football_project.services.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class Scheduler {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

//    @Scheduled(cron = "* */5 * * * ?")
    public void cron() {
        System.out.println("Current time: " + (Instant.now().plus(3, ChronoUnit.HOURS)));
    }

//    @Scheduled(cron = "* */10 * * * ?")
    public void saveAdminUser() {
        Optional<User> admin = userRepository.findByUsername("admin");

        if (admin.isPresent()) {
            System.out.println("Admin user is already present");
        } else {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setFirstName("admin");
            user.setLastName("admin");

            Role role = new Role();
            role.setName(UserRoleEnum.ADMIN);

            roleRepository.save(role);

            Set<Role> roles = new HashSet<>();
            roles.add(role);

            user.setRoles(roles);
            userRepository.save(user);
        }
    }

}
