package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.model.Recipe;
import dev.belueu.springbootrecipeapp.repository.RecipeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepo recipeRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        Recipe secondRecipe = new Recipe();
        secondRecipe.setId(1L);
        HashSet<Recipe> recipeHashSet = new HashSet<>();
        recipeHashSet.add(recipe);
        recipeHashSet.add(secondRecipe);

        when(recipeRepo.findAll()).thenReturn(recipeHashSet.stream().toList());

        Set<Recipe> recipes = recipeService.getRecipes();
        Assertions.assertEquals(3, recipes.size());
        verify(recipeRepo, times(1)).findAll();
    }
}