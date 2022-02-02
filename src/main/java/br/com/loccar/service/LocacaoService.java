package br.com.loccar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loccar.model.Locacao;
import br.com.loccar.repositories.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository repository;

	public List<Locacao> findAll() {
		return repository.findAll();
	}

	public Locacao findById(Integer id) {
		Optional<Locacao> locacao = repository.findById(id);
		return locacao.orElseThrow();
	}

	public Locacao save(Locacao locacao) {
		locacao.setIdentificador(null); // if id null jpa create new object
		return repository.save(locacao);
	}

}
