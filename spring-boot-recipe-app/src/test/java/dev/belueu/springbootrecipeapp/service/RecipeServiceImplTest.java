package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.converter.RecipeCommandToRecipe;
import dev.belueu.springbootrecipeapp.converter.RecipeToRecipeCommand;
import dev.belueu.springbootrecipeapp.model.Recipe;
import dev.belueu.springbootrecipeapp.repository.RecipeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepo recipeRepo;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepo, recipeCommandToRecipe, recipeToRecipeCommand);
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
        Assertions.assertEquals(2, recipes.size());
        verify(recipeRepo, times(1)).findAll();
    }

    @Test
    public void getRecipeById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepo, times(1)).findById(anyLong());
        verify(recipeRepo, never()).findAll();
    }

    @Test
    public void testDeleteById() {
        //given
        Long idToDelete = 2L;

        //when
        recipeService.deleteById(idToDelete);

        //then
        verify(recipeRepo, times(1)).deleteById(anyLong());
    }

}