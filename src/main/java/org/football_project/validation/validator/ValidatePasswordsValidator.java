package org.football_project.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.football_project.dtos.UserRegisterDTO;
import org.football_project.validation.annotation.ValidatePasswords;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ValidatePasswordsValidator implements ConstraintValidator<ValidatePasswords, UserRegisterDTO> {

    private String message;

    @Override
    public void initialize(ValidatePasswords constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserRegisterDTO userRegisterDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (userRegisterDTO.getPassword() == null || userRegisterDTO.getConfirmPassword() == null) {
            return true;
        }

        boolean isValid = userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword());

        if (!isValid) {
            constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class)
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();;
        }

        return isValid;
    }
}
