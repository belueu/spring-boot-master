package dev.belueu.springbootrecipeapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CategoryTest {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4L;

        category.setId(idValue);
        Assertions.assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
        String expectedValue = "Description";
        category.setDescription(expectedValue);

        Assertions.assertEquals(expectedValue, category.getDescription());
    }

    @Test
    void getRecipes() {
        Recipe first = new Recipe();
        first.setId(1L);
        Recipe second = new Recipe();
        second.setId(2L);

        Set<Recipe> expectedValue = new HashSet<>(List.of(first, second));
        category.setRecipes(expectedValue);

        Assertions.assertEquals(expectedValue.size(), category.getRecipes().size());
    }
}