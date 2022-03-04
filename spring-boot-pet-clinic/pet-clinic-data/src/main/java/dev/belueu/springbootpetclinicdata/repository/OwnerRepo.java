package dev.belueu.springbootpetclinicdata.repository;

import dev.belueu.springbootpetclinicdata.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {
}
