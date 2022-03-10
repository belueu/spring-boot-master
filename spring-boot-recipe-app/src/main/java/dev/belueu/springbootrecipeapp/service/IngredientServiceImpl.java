package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.command.IngredientCommand;
import dev.belueu.springbootrecipeapp.converter.IngredientCommandToIngredient;
import dev.belueu.springbootrecipeapp.converter.IngredientToIngredientCommand;
import dev.belueu.springbootrecipeapp.model.Ingredient;
import dev.belueu.springbootrecipeapp.model.Recipe;
import dev.belueu.springbootrecipeapp.repository.RecipeRepo;
import dev.belueu.springbootrecipeapp.repository.UnitOfMeasureRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final RecipeRepo recipeRepo;
    private final UnitOfMeasureRepo unitOfMeasureRepo;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient, RecipeRepo recipeRepo,
                                 UnitOfMeasureRepo unitOfMeasureRepo) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.recipeRepo = recipeRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepo.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            //todo impl error handling
            log.error("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientToIngredientCommand::convert).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //todo impl error handling
            log.error("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }

    @Override
    @Transactional
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {
        Optional<Recipe> recipeOptional = recipeRepo.findById(command.getRecipeId());

        if (!recipeOptional.isPresent()) {

            //todo toss error if not found!
            log.error("Recipe not found for id: " + command.getRecipeId());
            return new IngredientCommand();
        } else {
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if (ingredientOptional.isPresent()) {
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepo
                        .findById(command.getUom().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this
            } else {
                //add new Ingredient
                Ingredient ingredient = ingredientCommandToIngredient.convert(command);
                ingredient.setRecipe(recipe);
                recipe.addIngredient(ingredient);
            }

            Recipe savedRecipe = recipeRepo.save(recipe);

            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
                    .filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId()))
                    .findFirst();

            //check by description
            if (!savedIngredientOptional.isPresent()) {
                //not totally safe... But best guess
                savedIngredientOptional = savedRecipe.getIngredients().stream()
                        .filter(recipeIngredients -> recipeIngredients.getDescription().equals(command.getDescription()))
                        .filter(recipeIngredients -> recipeIngredients.getAmount().equals(command.getAmount()))
                        .filter(recipeIngredients -> recipeIngredients.getUom().getId().equals(command.getUom().getId()))
                        .findFirst();
            }

            //to do check for fail
            return ingredientToIngredientCommand.convert(savedIngredientOptional.get());
        }
    }

    @Override
    public void deleteById(Long recipeId, Long ingredientId) {
        log.debug("Deleting ingredient: " + recipeId + ":" + ingredientId);

        Optional<Recipe> recipeOptional = recipeRepo.findById(recipeId);

        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            log.debug("Found recipe with id: " + recipeId);

            Optional<Ingredient> ingredientOptional = recipe.getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(ingredientId))
                    .findFirst();

            if (ingredientOptional.isPresent()) {
                log.debug("Found ingredient with id: " + ingredientId);
                Ingredient ingredientToDelete = ingredientOptional.get();
                ingredientToDelete.setRecipe(null);
                recipe.getIngredients().remove(ingredientToDelete);
                recipeRepo.save(recipe);
            }
        } else {
            log.debug("Recipe with id: " + recipeId + " not found!");
        }
    }
}
