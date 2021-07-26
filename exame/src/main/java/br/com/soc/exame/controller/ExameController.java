package br.com.soc.exame.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.soc.exame.dto.ExameDTO;
import br.com.soc.exame.model.Exame;
import br.com.soc.exame.repository.ExameRepository;

@Controller
public class ExameController {
    @Autowired
    private ExameRepository repo;
    
    @GetMapping("/exames")
    public ModelAndView index() {
        List<Exame> exames = repo.findAll();
        // Orderna a exibição da tabela por nome
        Collections.sort(exames);
        
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
        if (result.hasErrors()) {
            System.out.println("***** Houve Erro *****\n" + result);
            ModelAndView mv = new ModelAndView("exames/novo");
            return mv;
        } else {
            Exame ex = exame.toExame();
            List<Exame> listaNome = repo.findAll();
            
            // Evita salvar nomes duplicados
            for (Exame e : listaNome) {
            	if (ex.getNome().equals(e.getNome())) {
            		return new ModelAndView("redirect:/");
            	}
            }
            repo.save(ex);
            return new ModelAndView("redirect:/exames");
        }
    }
    
    @GetMapping("/exames/{id}/edit")
    public ModelAndView editar(@PathVariable("id") Long id, ExameDTO exame) {
    	Optional<Exame> result = repo.findById(id);
    	if (result.isPresent()) {
    		Exame ex = result.get();
    		exame.setExame(ex);
    		ModelAndView mv = new ModelAndView("exames/editar");
    		mv.addObject("id", ex.getId());
    		return mv;
    	}
    	return new ModelAndView("redirect:/exames");
    }
    
    @PostMapping("/exames/{id}")
    public String update(@PathVariable("id") Long id, ExameDTO exameDTO) {
    	Optional<Exame> result = repo.findById(id);
    	
    	if (result.isPresent()) {
    		Exame ex = exameDTO.updateExame(result.get());
    		repo.save(ex);
    		return "redirect:/exames";
    	}
    	return "redirect:/index";
    }
    
    @GetMapping("exames/{id}/delete")
    public String deletar(@PathVariable("id") Long id) {
    	Optional<Exame> result = repo.findById(id);
    	
    	if (result.isPresent()) {
    		repo.deleteById(id);
    		return "redirect:/exames";
    	}
    	return "redirect:/";
    }
}
