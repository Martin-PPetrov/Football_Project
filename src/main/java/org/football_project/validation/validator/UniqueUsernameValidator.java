package org.football_project.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.football_project.services.UserService;
import org.football_project.validation.annotation.UniqueUsername;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (username == null || username.isEmpty()) {
            return true;
        }

        return userService.isUsernameUnique(username);
    }
}
