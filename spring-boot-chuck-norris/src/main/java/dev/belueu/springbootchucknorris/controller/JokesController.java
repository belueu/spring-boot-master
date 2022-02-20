package dev.belueu.springbootchucknorris.controller;

import dev.belueu.springbootchucknorris.service.ChuckNorrisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private final ChuckNorrisService chuckNorrisService;

    public JokesController(ChuckNorrisService chuckNorrisService) {
        this.chuckNorrisService = chuckNorrisService;
    }

    @RequestMapping("/chuck-norris/jokes")
    public String getRandomChuckNorrisJoke(Model model) {
        model.addAttribute("joke", chuckNorrisService.getChuckNorrisRandomJoke());
        return "chucknorris/jokes";
    }
}
