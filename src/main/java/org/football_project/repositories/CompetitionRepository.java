package org.football_project.repositories;

import org.football_project.entities.Competiton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competiton, Long> {
}
