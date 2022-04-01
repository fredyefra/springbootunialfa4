package br.com.loccar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loccar.model.Cliente;
import br.com.loccar.repositories.ClienteRepository;

@Controller
public class ClienteController implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteRepository repository;

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger
			.getLogger(ClienteController.class.getName());

	@GetMapping("/clientes")
	public ModelAndView index() {
		List<Cliente> clientes = repository.findAll();
		ModelAndView mv = new ModelAndView("cliente/clientes");
		mv.addObject("clientes", clientes);
		return mv;
	}

	@GetMapping(value = "/cadastrar-cliente")
	public String navegacaoCadastrar(Cliente cliente) {
		/*
		 * this.cliente = new Cliente(); ModelAndView mv = new
		 * ModelAndView("cliente/cadastrar-cliente"); mv.addObject("cliente",
		 * this.cliente);
		 */
		return "cliente/cadastrar-cliente";
	}

	@PostMapping("/clientes")
	public ModelAndView save(@Valid Cliente dto, BindingResult result, Model model) {

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("cliente/cadastrar-cliente") ;
            //mv.addObject("cliente", this.cliente);
            //return "cliente/cadastrar-cliente";
			return mv;
		}

		/*
		 * else { // Cliente cliente = dto.toCliente(); this.cliente = cliente;
		 * repository.save(this.cliente); //
		 * attributes.addFlashAttribute("mensagem","Cliente cadastrado com sucesso! ");
		 * LOGGER.info("Parametros DTO " + this.cliente);
		 * 
		 * ModelAndView mv = new ModelAndView("cliente/clientes");
		 * mv.addObject("cliente", this.cliente);
		 * 
		 * return mv; }
		 */

		
			//this.cliente = dto.toCliente();
			
			repository.save(dto);
			LOGGER.info("Objeto Status ------> " + dto.getClass().getName());
			
			return new ModelAndView("redirect:/clientes");
		
		
	}

		
	/**
	 * Exclui o cliente na base
	 **//*
		 * @GetMapping(value = "delete/{identificador}") public String
		 * deleteStudent(@PathVariable("identificador") Integer identificador, Model
		 * model, RedirectAttributes attributes) { Cliente cliente =
		 * repository.findByIdentificador(identificador); repository.delete(cliente);
		 * attributes.addFlashAttribute("mensagem", "Cliente excluido com sucesso " +
		 * cliente.getNome()+"."); model.addAttribute("clientes", repository.findAll());
		 * return "redirect:/clientes"; }
		 * 
		 * public Cliente getCliente() { return cliente; }
		 * 
		 * public void setCliente(Cliente cliente) { this.cliente = cliente; }
		 */

}
