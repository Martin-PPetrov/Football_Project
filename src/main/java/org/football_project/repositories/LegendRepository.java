package org.football_project.repositories;

import org.football_project.entities.Legend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegendRepository extends JpaRepository<Legend, Long> {
}
