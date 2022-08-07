package com.projeto.padroes.acaif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model m) {
		
		return "index";
	}
	
	@RequestMapping("/index")
	public String index2(Model m) {
		return "index";
	}
}
