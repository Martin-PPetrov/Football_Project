package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.football_project.entities.enums.TitleEnum;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "managers")
public class Manager extends Person {

    @Column
    @Enumerated(EnumType.STRING)
    private TitleEnum title;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club currentClub;

    //TODO: all time clubs

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "manager_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "club_id", referencedColumnName = "id")
    )
    private Set<Club> allTimeClubs = new HashSet<>();

}
