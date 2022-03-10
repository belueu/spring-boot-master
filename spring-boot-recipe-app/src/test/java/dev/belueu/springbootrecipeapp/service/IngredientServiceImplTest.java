package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.command.IngredientCommand;
import dev.belueu.springbootrecipeapp.converter.IngredientCommandToIngredient;
import dev.belueu.springbootrecipeapp.converter.IngredientToIngredientCommand;
import dev.belueu.springbootrecipeapp.converter.UnitOfMeasureCommandToUnitOfMeasure;
import dev.belueu.springbootrecipeapp.converter.UnitOfMeasureToUnitOfMeasureCommand;
import dev.belueu.springbootrecipeapp.model.Ingredient;
import dev.belueu.springbootrecipeapp.model.Recipe;
import dev.belueu.springbootrecipeapp.repository.RecipeRepo;
import dev.belueu.springbootrecipeapp.repository.UnitOfMeasureRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngredientServiceImplTest {

    @InjectMocks
    IngredientToIngredientCommand ingredientToIngredientCommand;

    @InjectMocks
    IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Mock
    UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    @Mock
    RecipeRepo recipeRepo;

    @Mock
    UnitOfMeasureRepo unitOfMeasureRepo;

    @InjectMocks
    IngredientServiceImpl ingredientService;

//    //init converters
//    public IngredientServiceImplTest() {
//        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
//    }

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient, recipeRepo, unitOfMeasureRepo);
    }

    @Test
    public void findByRecipeIdAndId() throws Exception {
    }

    @Test
    public void findByRecipeIdAndRecipeIdHappyPath() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        //when
        assertEquals(3L, ingredientCommand.getId());
        assertEquals(1L, ingredientCommand.getRecipeId());
        verify(recipeRepo, times(1)).findById(anyLong());
    }

    @Test
    public void testSaveRecipeCommand() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);

        when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepo.save(any())).thenReturn(savedRecipe);

        //when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        //then
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepo, times(1)).findById(anyLong());
        verify(recipeRepo, times(1)).save(any(Recipe.class));

    }

    @Test
    void testDeleteById() {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Ingredient ingredient = new Ingredient();
        ingredient.setId(3L);
        recipe.addIngredient(ingredient);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);

        //when
        ingredientService.deleteById(1L, 3L);

        //then
        verify(recipeRepo, times(1)).findById(anyLong());
        verify(recipeRepo, times(1)).save(any(Recipe.class));
    }
}