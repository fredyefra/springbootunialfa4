package br.com.loccar.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loccar.model.Cliente;
import br.com.loccar.model.Veiculo;
import br.com.loccar.repositories.ClienteRepository;
import br.com.loccar.repositories.VeiculoRepository;

@Service
public class DataService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public void startDB() {

		Cliente c1 = new Cliente(null, "Thomas Edson", "Rua XV de Novembro - Esquina 50", "9999-9999", "thomasedson@email.com");
		Cliente c2 = new Cliente(null, "Marie Curie", "Nova Venezia - Rua 777", "5555-4444", "mariecurie@email.com");
		Cliente c3 = new Cliente(null, "James Gosling", "Bahia Beach - Centro 32", "8888-7777", "jamesgosling@email.com");
		Cliente c4 = new Cliente(null, "Steve Jobs", "Vale do Silicio", "9999-0000","stevejobs@email.com");
		Cliente c5 = new Cliente(null, "Parag Agrawal", "Ajmer Division ", "9999-0000","paragagrawal@email.com");
		
		
		/*
		 * Veiculo v1 = new Veiculo(null, "Mustang Gt", "Ford", "2018-2019", 2018, c1);
		 * Veiculo v2 = new Veiculo(null, "Puma Gts", "Puma", "  1971-1972", 1971, c1);
		 * Veiculo v3 = new Veiculo(null, "Volvo Xc60", "Volvo", "2017-2018", 2017, c2);
		 * Veiculo v4 = new Veiculo(null, "Audi TT", "Audi", "2012-2013", 2012, c3);
		 */

		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4,c5));
		//veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4));

	}
}