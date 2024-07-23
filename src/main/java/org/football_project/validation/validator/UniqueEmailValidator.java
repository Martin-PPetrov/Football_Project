package org.football_project.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.football_project.services.UserService;
import org.football_project.validation.annotation.UniqueEmail;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null || email.isEmpty()) {
            return true;
        }

        return userService.isEmailUnique(email);
    }
}
