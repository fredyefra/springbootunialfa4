package br.com.loccar.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loccar.model.Cliente;
import br.com.loccar.repositories.ClienteRepository;

@Controller
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteRepository repository;

	// http://localhost:8080/clientes Listar
	
	/**
	 * Redireciona para pagina listar clientes
	 **/
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Cliente> clientes = repository.findAll();
		model.addAttribute("clientes", clientes);
		return "cliente/clientes";
	}

	/**
	 * Redireciona para o form salvar cliente
	 **/
	@RequestMapping(value = "/cadastrar-cliente")
	public String navegacaoCadastrar(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/cadastrar-cliente";
	}

	/**
	 * Salva  o cliente na base
	 **/
	@RequestMapping(value="/cadastrar-cliente", method=RequestMethod.POST)
	public String save(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos obrigatórios!");
			return "redirect:/cadastrar-cliente";
		}
		repository.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso " + cliente.getNome()+".");
		return "redirect:/clientes";
	}

	/**
	 * Exclui  o cliente na base
	 **/
	@GetMapping(value = "delete/{identificador}")
    public String deleteStudent(@PathVariable("identificador") Integer identificador, Model model, RedirectAttributes attributes) {
        Cliente cliente = repository.findByIdentificador(identificador);
        repository.delete(cliente);
        attributes.addFlashAttribute("mensagem", "Cliente excluido com sucesso " + cliente.getNome()+".");
        model.addAttribute("clientes", repository.findAll());
        return "redirect:/clientes";
    }
}