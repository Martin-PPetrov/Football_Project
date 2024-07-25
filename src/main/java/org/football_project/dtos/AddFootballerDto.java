package org.football_project.dtos;

import lombok.Data;

@Data
public class AddFootballerDto {

    private String name;
    private int age;
    private String nationality;
    private String position;
    private int goalsCount;
    private int assistsCount;
    private int matchesCount;

}
