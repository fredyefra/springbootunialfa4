package br.com.loccar.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.loccar.model.Cliente;

public class ClienteDTO {

	private String nome;
	private String endereco;
	private String telefone;
	private String email;

	public ClienteDTO() {

	}

	public Cliente toCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(this.nome);
		cliente.setEndereco(this.endereco);
		cliente.setTelefone(this.telefone);
		cliente.setEmail(this.email);

		return  cliente;

	} 

	public void fromCliente(Cliente cliente) {
		this.nome = cliente.getNome();
	    this.endereco = cliente.getEndereco();
	    this.telefone = cliente.getTelefone();
	    this.email = cliente.getEmail();
	}
	
	@NotBlank 
	@NotNull (message = "Campo obrigatório DTO!")
	@Length(min = 3, max = 30, message = "O Campo deve ter entre 3 e 50 caracteres.")
	public String getNome() {
		return nome;
	}

    public void setNome(String nome) {
		this.nome = nome;
	}
	
    
    @NotBlank (message = "Campo obrigatório DTO!")
	@NotNull (message = "Campo obrigatório DTO!")
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@NotBlank (message = "Campo obrigatório DTO!")
	@NotNull (message = "Campo obrigatório DTO!")
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ClienteDTO [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email
				+ "]";
	}
}