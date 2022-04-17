package br.com.loccar.controller;

import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loccar.model.Cliente;
import br.com.loccar.service.ClienteService;

@Controller
public class ClienteController implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteService service;

	private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());
	
	@GetMapping("/clientes")
	public ModelAndView index(Model model, @RequestParam (defaultValue = "0") int pageNumber) {
		
		model.addAttribute("data", service.findAll(PageRequest.of(pageNumber, 4)));
	    model.addAttribute("currentPage", pageNumber);	
		return new ModelAndView("cliente/clientes");
	}

	@GetMapping(value = "/cadastrar-cliente")
	public String navigationSave(Cliente cliente) {
		return "cliente/cadastrar-cliente";
	}
	  
	@PostMapping("/clientes")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("cliente/cadastrar-cliente");
			return mv;
		} 
		// this.cliente = dto.toCliente();
		service.save(cliente);
		attributes.addFlashAttribute("message", "Cliente salvo com sucesso!");

		return new ModelAndView("redirect:/clientes");

	}
	  
	@GetMapping("/clientes/{id}/edit")
	public ModelAndView navigationEdit(@Valid @PathVariable Integer id) {
	  
		Optional<Cliente> optional = service.findById(id);

		Cliente cliente = optional.get();
		ModelAndView mv = new ModelAndView("cliente/detalhar-cliente");
		mv.addObject(cliente);
		return mv;
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

			service.update(id, x);
			attributes.addFlashAttribute("message", "Alteração efetuada com sucesso!");
			ModelAndView mv = new ModelAndView("redirect:/clientes");
			return mv;
		}
		return new ModelAndView("redirect:/clientes");
	}

	
	/*
	 * @GetMapping("/clientes/{id}/delete")
	 * 
	 * @ResponseBody public Cliente navigationDelete(@Valid @PathVariable Integer
	 * id) {
	 * 
	 * Optional<Cliente> optional = service.findById(id);
	 * 
	 * 
	 * Cliente cliente = optional.get(); LOGGER.info("Identicador Parametro " + id
	 * ); LOGGER.info("Identicador Objeto " + cliente.getIdentificador());
	 * 
	 * 
	 * 
	 * return cliente;
	 * 
	 * }
	 */

	
	@GetMapping("/clientes/{id}/delete")
	public ModelAndView navigationDelete(@Valid @PathVariable Integer id, Cliente cliente) {
	  
		Optional<Cliente> optional = service.findById(id);

		cliente = optional.get();
		ModelAndView mv = new ModelAndView("cliente/clientes");
		mv.addObject(cliente);
		return mv;
	}

	
	
	@GetMapping(value = "/clientes/{id}") 
	public ModelAndView delete(@Valid @PathVariable Integer id, Cliente cliente, Model model, 
			RedirectAttributes attributes) {

		Optional<Cliente> optional = service.findById(id); //
		 
		cliente = optional.get();
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		mv.addObject(cliente);
		model.addAttribute("cliente",cliente);
		
		service.delete(cliente.getIdentificador());
		
		attributes.addFlashAttribute("mensagem", "Cliente excluido com sucesso" + cliente.getNome()); 
		
		return mv;
   }
	 
	 
}