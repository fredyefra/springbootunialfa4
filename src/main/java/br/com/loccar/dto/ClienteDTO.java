package br.com.loccar.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	
	/*
	 * @NotEmpty(message = "Campo NOME é requerido")
	 * 
	 * @Length(min = 3, max = 100, message =
	 * "O Campo NOME deve ter entre 3 e 50 caracteres")
	 * 
	 * @Column(nullable = false)
	 * 
	 * @NotNull(message = "Não pode ser nulo!")
	 */
	
	//@NotEmpty(message = "Campo NOME é requerido")
	@NotBlank
	@NotNull
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	@NotNull
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
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