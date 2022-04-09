package br.com.loccar.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loccar.model.Cliente;
import br.com.loccar.repositories.ClienteRepository;

@Controller
public class ClienteController implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteRepository service;

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger
			.getLogger(ClienteController.class.getName());

	@GetMapping("/clientes")
	public ModelAndView index() {
		List<Cliente> clientes = service.findAll();
		ModelAndView mv = new ModelAndView("cliente/clientes");
		mv.addObject("clientes", clientes);
		return mv;
	}

	@GetMapping(value = "/cadastrar-cliente")
	public String navigationSave(Cliente cliente) {
		return "cliente/cadastrar-cliente";
	}

	@PostMapping("/clientes")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("cliente/cadastrar-cliente") ;
			return mv;
		}
		//this.cliente = dto.toCliente();
		service.save(cliente);
		attributes.addFlashAttribute("message", "Cliente salvo com sucesso!");
		LOGGER.info("Objeto Status ------> " + cliente.getClass().getName());

		return new ModelAndView("redirect:/clientes");

	}

	@GetMapping("/clientes/{id}/edit")
	public ModelAndView navigationEdit(@Valid @PathVariable Integer id) {

        Optional<Cliente> optional = service.findById(id);
		
		if (optional.isPresent()) {
        	Cliente cliente = optional.get();
        	ModelAndView mv = new ModelAndView("cliente/detalhar-cliente");
        	mv.addObject(cliente);
        	return mv;
		}
        return new ModelAndView("redirect:/clientes");
	}

  
	@PostMapping("/clientes/{id}")
	public ModelAndView edit(@Valid @PathVariable Integer id, Cliente cliente, RedirectAttributes attributes) {

        Optional<Cliente> optional = service.findById(id);
		
		if (optional.isPresent()) {
        	Cliente x = optional.get();
        	
        	x.setNome(cliente.getNome());
        	x.setEndereco(cliente.getEndereco());
        	x.setTelefone(cliente.getTelefone());
        	x.setEmail(cliente.getEmail());
        	
        	service.save(x);
        	attributes.addFlashAttribute("message", "Alteração efetuada com sucesso!");
        	ModelAndView mv = new ModelAndView("redirect:/clientes");
        	//mv.addObject(optional.get());
        	return mv;
		}
        return new ModelAndView("redirect:/clientes");
	}

	
	/*
	 * @GetMapping("/clientes/{id}") public ModelAndView
	 * detalhar(@Valid @PathVariable Integer id, Cliente cliente) {
	 * 
	 * //cliente = service.findById(id); //Cliente obj = service.update(id,
	 * cliente);
	 * 
	 * Optional<Cliente> optional = service.findById(id);
	 * 
	 * Cliente x = optional.get();
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView("cliente/detalhar-cliente");
	 * mv.addObject("clienteid",x.getIdentificador());
	 * 
	 * service.save(x);
	 * 
	 * //mv.addObject(obj);
	 * 
	 * return mv; }
	 */
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