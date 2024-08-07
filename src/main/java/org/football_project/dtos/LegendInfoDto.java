package org.football_project.dtos;

import lombok.Data;
import org.football_project.entities.enums.PositionEnum;

@Data
public class LegendInfoDto {

    private String name;
    private int age;
    private PositionEnum position;
    private int goalsCount;
    private int assistsCount;
    private int matchesCount;

}
