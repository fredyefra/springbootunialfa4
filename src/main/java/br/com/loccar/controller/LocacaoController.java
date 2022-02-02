package br.com.loccar.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.loccar.model.Locacao;
import br.com.loccar.repositories.LocacaoRepository;

@Controller
public class LocacaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LocacaoRepository repository;

	/**
	 * Redireciona para pagina listar locacoes
	 **/
	@RequestMapping(value = "/locacoes", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Locacao> locacoes = repository.findAll();
		model.addAttribute("locacoes", locacoes);
		return "locacao/locacoes";
	}

}