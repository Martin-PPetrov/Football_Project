package org.football_project.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.football_project.entities.enums.PositionEnum;
import org.football_project.entities.enums.TitleEnum;

@Data
public class AddManagerDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Min(18)
    @Max(100)
    private int age;

    @NotNull
    private TitleEnum title;

}
