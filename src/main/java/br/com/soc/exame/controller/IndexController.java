package br.com.soc.exame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String exames(Model model) {
        model.addAttribute("nome", "Thymeleaf!");
        return "index";
    }
}
