package br.com.loccar.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loccar.model.Cliente;
import br.com.loccar.model.Locacao;
import br.com.loccar.model.Veiculo;
import br.com.loccar.repositories.ClienteRepository;
import br.com.loccar.repositories.LocacaoRepository;
import br.com.loccar.repositories.VeiculoRepository;

@Service
public class DataService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public void startDB() {

		Cliente c1 = new Cliente(null, "Robert C. Martin", "California - EUA", "9999-9999","robertmartin@email.com");
		Cliente c2 = new Cliente(null, "Martin Fowler", "Walsall - Reino Unido", "5555-4444", "martinfowler@email.com");
		Cliente c3 = new Cliente(null, "James Gosling", "Calgary Alberta - Canada", "8888-7777","jamesgosling@email.com");
		Cliente c4 = new Cliente(null, "Steve Jobs", "Sao Francisco California - EUA", "9999-0000", "stevejobs@email.com");
		Cliente c5 = new Cliente(null, "Parag Agrawal", "Ajmer Rajasthan - India ", "9999-0000", "paragagrawal@email.com");
		Cliente c6 = new Cliente(null, "Erich Gamma", "Zurique - Suiça", "8888-0000", "erichgamma@email.com");
		Cliente c7 = new Cliente(null, "James Rumbaugh", "Pensilvânia - EUA", "3333-0000", "jamesrumbaugh@email.com");
		Cliente c8 = new Cliente(null, "Larry Page", "Michigan - EUA", "8888-0000", "larrypage@email.com");
		Cliente c9 = new Cliente(null, "Dennis Ritchie", "Nova Iorque - EUA", "1111-0000", "dennisritchie@email.com");  
		Cliente c10 = new Cliente(null, "Edgar Frank Codd", "Fortuneswell - Reino Unido", "0000-0000", "edgarfrankcodd@email.com");
		Cliente c11 = new Cliente(null, "Linus Torvalds", "Helsinque - Finlândia", "9999-0000", "linustorvalds@email.com");
		Cliente c12 = new Cliente(null, "Tim Cook", "Robertsdale - EUA", "1111-0000", "timcook@email.com" );
		Cliente c13 = new Cliente(null, "Larry Ellison", "Nova Iorque - EUA - EUA", "8888-0000", "larryellison@email.com");
		
		Veiculo v1 = new Veiculo(null, "Mustang Gt", "Ford", "2018-2019", 2018);
		Veiculo v2 = new Veiculo(null, "Puma Gts", "Puma", "  1971-1972", 1971);
		Veiculo v3 = new Veiculo(null, "Volvo Xc60", "Volvo", "2017-2018", 2017);
		Veiculo v4 = new Veiculo(null, "Audi TT", "Audi", "2012-2013", 2012);

		Locacao l1 = new Locacao(null, c1, v1);
		Locacao l2 = new Locacao(null, c2, v2);
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5,c6,c7,c8,c9,c10,c11,c12,c13));
		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4));
		locacaoRepository.saveAll(Arrays.asList(l1,l2));

	}
}