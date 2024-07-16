package org.football_project.dtos;

import lombok.Data;

@Data
public class UserRegisterDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String password;
    private String confirmPassword;
}
