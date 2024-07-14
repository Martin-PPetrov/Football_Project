package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private Set<Footballer> footballers;
}
