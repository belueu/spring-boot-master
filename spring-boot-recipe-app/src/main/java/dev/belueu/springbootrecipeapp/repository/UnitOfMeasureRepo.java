package dev.belueu.springbootrecipeapp.repository;

import dev.belueu.springbootrecipeapp.model.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfMeasureRepo extends JpaRepository<UnitOfMeasure, Long> {
}
