package br.com.soc.exame.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.soc.exame.model.Exame;
import br.com.soc.exame.repository.ExameRepository;

@RestController
@RequestMapping("/consulta")
public class ExameController {
	@Autowired
	private ExameRepository repo;
	
	@GetMapping("/")
	public ModelAndView Teste(Model model) {
		ModelAndView mv = new ModelAndView("cadastrar");
		List<Exame> exame = repo.findAll();
		model.addAttribute("exame", exame);
		return mv;
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Exame> get(@PathVariable("id") Long id) {
		Optional<Exame> exame = repo.findById(id);
		return exame;
	}
	
	@PostMapping("/consulta")
	public String create(Exame exame) {
		System.out.println("\n" + exame.toString());
		return "redirect:/index";
	}
	
	@DeleteMapping("/")
	public boolean deletar(@RequestBody Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
}
