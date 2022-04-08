package br.com.loccar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loccar.model.Cliente;
import br.com.loccar.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;


	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Integer id) {
		Optional<Cliente>  optional = repository.findById(id);
		return optional.orElseThrow(() -> new RuntimeException("Objeto não encontrado! id: " + id + Cliente.class));
	}

	public Cliente save(Cliente  cliente) {
		cliente.setIdentificador(null); // if id null jpa create new object
		return repository.save(cliente);
	}

	public Cliente update(Integer id, Cliente obj) {
		Cliente cliente = findById(id); // if id exist jpa update object
		cliente.setNome(obj.getNome());
		cliente.setEndereco(obj.getEndereco());
		return repository.save(cliente);
	}

}