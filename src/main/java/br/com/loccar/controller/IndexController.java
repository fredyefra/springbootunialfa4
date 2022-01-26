package br.com.loccar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
	/**
	* Redireciona para pagina index
	**/   
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
