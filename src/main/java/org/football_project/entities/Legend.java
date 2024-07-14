package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.football_project.entities.enums.PositionEnum;

@Entity
@Getter
@Setter
@Table(name = "legends")
public class Legend extends Person {

    @Column
    @Enumerated(EnumType.STRING)
    private PositionEnum position;

    @Column(name = "goals_count")
    private int goalsCount;

    @Column(name = "assists_count")
    private int assistsCount;

    @Column(name = "matches_count")
    private int matchesCount;

    //TODO: all time clubs
}
