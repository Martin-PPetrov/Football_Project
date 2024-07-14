package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "clubs")
public class Club extends BaseEntity {

    @Column
    private String name;

    @Column(name = "year_of_foundation")
    private int yearOfFoundation;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "currentClub")
    private Set<Footballer> footballers = new HashSet<>();

    @OneToMany(mappedBy = "currentClub")
    private Set<Manager> managers = new HashSet<>();

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "club_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "competition_id", referencedColumnName = "id")
    )
    private Set<Competiton> competitons = new HashSet<>();
}
