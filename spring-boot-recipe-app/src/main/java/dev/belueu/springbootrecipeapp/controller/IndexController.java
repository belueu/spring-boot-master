package dev.belueu.springbootrecipeapp.controller;

import dev.belueu.springbootrecipeapp.repository.RecipeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeRepo recipeRepo;

    public IndexController(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeRepo.findAll());
        return "index";
    }
}
