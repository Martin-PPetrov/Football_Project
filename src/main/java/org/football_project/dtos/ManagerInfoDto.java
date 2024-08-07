package org.football_project.dtos;

import lombok.Data;
import org.football_project.entities.enums.PositionEnum;
import org.football_project.entities.enums.TitleEnum;

@Data
public class ManagerInfoDto {

    private String name;
    private int age;
    private TitleEnum title;

}
