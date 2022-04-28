package br.com.loccar.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.loccar.dto.ClienteDTO;
import br.com.loccar.model.Cliente;

@Service
public class Mapper {

	@Bean
	public org.modelmapper.ModelMapper modelMapper() {
		return new org.modelmapper.ModelMapper();
	}

	//@Bean
	public Cliente converteParaEntidade(ClienteDTO dto) {
		Cliente cliente = modelMapper().map(dto, Cliente.class);
		return cliente;
	}

}
