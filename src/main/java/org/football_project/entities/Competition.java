package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "competitions")
public class Competition extends BaseEntity {

    @Column
    private String name;

    @ManyToMany(mappedBy = "competitions")
    private Set<Club> clubs = new HashSet<>();
}
