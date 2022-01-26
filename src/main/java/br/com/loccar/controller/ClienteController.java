package br.com.loccar.controller;

import java.io.Serializable;
import java.util.List;

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
	 * Redireciona para pagina listar clientes
	 **/
	@RequestMapping("/clientes")
	public String listar(Model model) {
		List<Cliente> clientes = repository.findAll();
		model.addAttribute("clientes", clientes);
		return "cliente/clientes";
	}

	/**
	 * Redireciona para pagina salvar cliente
	 **/
	@RequestMapping("/cadastrar-cliente")
	public String navegacaoCadastrar(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/cadastrar-cliente";
	}
}