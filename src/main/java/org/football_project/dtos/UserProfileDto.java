package org.football_project.dtos;

import lombok.Data;

@Data
public class UserProfileDto {

    private String username;
    private String firstName;
    private String lastName;
    private int age;

}
