package br.com.loccar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.loccar.model.Cliente;
import br.com.loccar.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Iterable<Cliente> findAll() { 
		Iterable<Cliente> iterable = repository.findAll(); 
		return iterable; 
	}

	public Page<Cliente> findAll(int pageNum,int pageSize) { 
		
		Sort sort = Sort.by(Direction.ASC,"identificador");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);

	    return repository.findAll(pageable); 
	}

	public Page<Cliente> findAll(PageRequest request) {
		request.getSortOr(Sort.by(Direction.DESC, "nome"));
		return repository.findAll(request);
	}
	
	public Optional<Cliente> findById(Integer id) {
		Optional<Cliente>  optional = repository.findById(id);
		return optional;
	}
	
	// if id null jpa create new object
	public Cliente save(Cliente  cliente) {
		cliente.setIdentificador(null); 
		return repository.save(cliente);
	}

	//if id exist jpa update object
	public Cliente update(Integer id, Cliente obj) {
		Optional<Cliente> optional = findById(id);
		Cliente cliente = optional.get(); // 
		return repository.save(cliente);
	}

	public void delete (Integer id) {
      repository.deleteById(id);		
	}
}