package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.command.RecipeCommand;
import dev.belueu.springbootrecipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);
}
