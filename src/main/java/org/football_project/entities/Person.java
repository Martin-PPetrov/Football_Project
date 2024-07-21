package org.football_project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person extends BaseEntity {

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country nationality;

}
