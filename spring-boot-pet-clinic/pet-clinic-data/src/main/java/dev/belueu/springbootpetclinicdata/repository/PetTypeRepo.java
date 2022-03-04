package dev.belueu.springbootpetclinicdata.repository;

import dev.belueu.springbootpetclinicdata.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepo extends JpaRepository<PetType, Long> {
}
