package dev.belueu.springbootrecipeapp.repository;

import dev.belueu.springbootrecipeapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
