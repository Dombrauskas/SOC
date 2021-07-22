package br.com.soc.exame.controller;

import br.com.soc.exame.dto.ExameDTO;
import br.com.soc.exame.model.Exame;
import br.com.soc.exame.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExameController {
    @Autowired
    private ExameRepository repo;
    
    @GetMapping("/exames")
    public ModelAndView index() {
        List<Exame> exames = repo.findAll();
        ModelAndView mv = new ModelAndView("exames/index");
        mv.addObject("exames", exames);
        return mv;
    }
    
    @GetMapping("/exames/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("exames/novo");
        ExameDTO exameDTO = new ExameDTO();
        mv.addObject("exameDTO", exameDTO);
        return mv;
    }
    
    @PostMapping("/exames")
    public ModelAndView create(@Valid ExameDTO exame, BindingResult result) {
        System.out.println("\n" + exame + "\n");
        if (result.hasErrors()) {
            System.out.println("***** Houve Erro *****\n" + result);
            ModelAndView mv = new ModelAndView("exames/novo");
            return mv;
        } else {
            Exame ex = exame.toExame();
            repo.save(ex);
            return new ModelAndView("redirect:/exames");
        }
    }
}
