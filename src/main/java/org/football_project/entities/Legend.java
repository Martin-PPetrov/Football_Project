package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.football_project.entities.enums.PositionEnum;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "legend_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "club_id", referencedColumnName = "id")
    )
    private Set<Club> allTimeClubs = new HashSet<>();

}
