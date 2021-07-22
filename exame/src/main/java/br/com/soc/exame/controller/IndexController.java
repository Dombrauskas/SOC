package br.com.soc.exame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.soc.exame.model.Exame;
import br.com.soc.exame.repository.ExameRepository;

@Controller
public class IndexController {
	@Autowired
	private ExameRepository repo;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Exame> exame = repo.findAll();
		model.addAttribute("exames", exame);
		return "index";
	}
	
	@GetMapping("/novo")
	public String cadastrar() {
		return "novo";
	}
}
