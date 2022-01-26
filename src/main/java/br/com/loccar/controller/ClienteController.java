package br.com.loccar.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loccar.repositories.ClienteRepository;

@Controller
public class ClienteController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClienteRepository repository;
	
	/**
	* Redireciona para pagina listar livro
	**/
	@RequestMapping("cliente/listar")
	public String cadastrar(Model model) {
		model.addAttribute("clientes", repository.findAll());
		return "cliente/listar";
	}

}