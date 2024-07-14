package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.football_project.entities.enums.TitleEnum;

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
}
