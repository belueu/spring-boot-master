package dev.belueu.springbootpetclinicweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    @RequestMapping({"","/", "/index", "/index.html"})
    public String listVets(Model model) {
//        model.addAttribute("vets", )
        return "vets/index";
    }
}
