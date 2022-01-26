package br.com.loccar.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loccar.model.Cliente;
import br.com.loccar.repositories.ClienteRepository;

@Controller
public class ClienteController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClienteRepository repository;
	
	/**
	* Redireciona para pagina listar livro
	**/
	@RequestMapping("cliente/clientes")
	public String cadastrar(Model model) {
		model.addAttribute("clientes", repository.findAll());
		return "cliente/clientes";
	}

	/*
	 * @RequestMapping("cliente/cadastrar-cliente") public String
	 * showNewProductPage(Model model) { Cliente cliente = new Cliente();
	 * model.addAttribute("cliente", cliente);
	 * 
	 * return "cliente/cadastrar-cliente"; }
	 */
	
	
}