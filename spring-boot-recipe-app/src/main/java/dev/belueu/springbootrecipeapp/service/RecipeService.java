package dev.belueu.springbootrecipeapp.service;

import dev.belueu.springbootrecipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
