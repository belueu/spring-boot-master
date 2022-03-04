package dev.belueu.springbootpetclinicdata.repository;

import dev.belueu.springbootpetclinicdata.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {
}
