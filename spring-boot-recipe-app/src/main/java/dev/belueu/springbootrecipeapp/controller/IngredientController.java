package dev.belueu.springbootrecipeapp.controller;

import dev.belueu.springbootrecipeapp.command.IngredientCommand;
import dev.belueu.springbootrecipeapp.command.RecipeCommand;
import dev.belueu.springbootrecipeapp.command.UnitOfMeasureCommand;
import dev.belueu.springbootrecipeapp.service.IngredientService;
import dev.belueu.springbootrecipeapp.service.RecipeService;
import dev.belueu.springbootrecipeapp.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService,
                                IngredientService ingredientService,
                                UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable Long recipeId, Model model) {
        log.debug("Getting ingredient list from recipe id: " + recipeId);

        model.addAttribute("recipe", recipeService.findCommandById(recipeId));

        return "recipe/ingredient/list";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showRecipeIngredient(@PathVariable Long recipeId,
                                       @PathVariable Long ingredientId,
                                       Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId));

        return "recipe/ingredient/show";
    }

    @GetMapping("recipe/{recipeId}/ingredient/new")
    public String newRecipeIngredient(@PathVariable Long recipeId,
                                      Model model) {
        RecipeCommand recipeCommand = recipeService.findCommandById(recipeId);
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(recipeId);
        model.addAttribute("ingredient", ingredientCommand);

        ingredientCommand.setUom(new UnitOfMeasureCommand());
        model.addAttribute("uomList", unitOfMeasureService.listUoms());

        return "recipe/ingredient/ingredientform";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable Long recipeId,
                                         @PathVariable Long ingredientId,
                                         Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId));
        model.addAttribute("uomList", unitOfMeasureService.listUoms());

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command) {
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved receipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{ingredientId}/delete")
    public String deleteIngredient(@PathVariable Long recipeId,
                                   @PathVariable Long ingredientId) {
        log.debug("Deleting ingredient with id: " + ingredientId);
        ingredientService.deleteById(recipeId, ingredientId);

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
