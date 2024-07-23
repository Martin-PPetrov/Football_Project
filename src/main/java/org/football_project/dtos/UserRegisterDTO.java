package org.football_project.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.football_project.validation.annotation.UniqueEmail;
import org.football_project.validation.annotation.UniqueUsername;

@Data
public class UserRegisterDTO {

    @NotBlank
    @Size(min = 2, max = 200)
    @UniqueUsername
    private String username;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String lastName;

    @Email(regexp = ".*@.*")
    @UniqueEmail
    private String email;

    @Min(1)
    @Max(100)
    private Integer age;

    @Size(min = 5, max = 100)
    private String password;

    private String confirmPassword;
}
