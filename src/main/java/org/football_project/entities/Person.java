package org.football_project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "people")
public class Person extends BaseEntity {

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country nationality;

}
