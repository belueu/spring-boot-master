package dev.belueu.springbootpetclinicdata.repository;

import dev.belueu.springbootpetclinicdata.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepo extends JpaRepository<Visit, Long> {
}
