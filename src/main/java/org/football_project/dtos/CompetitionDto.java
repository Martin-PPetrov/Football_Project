package org.football_project.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CompetitionDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

}
