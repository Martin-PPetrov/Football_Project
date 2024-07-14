package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "footballers")
public class Footballer extends Person {

    @Column
    @Enumerated(EnumType.STRING)
    private PositionEnum position;

    @Column(name = "goals_count")
    private int goalsCount;

    @Column(name = "assists_count")
    private int assistsCount;

    @Column(name = "matches_count")
    private int matchesCount;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club currentClub;
    
}
