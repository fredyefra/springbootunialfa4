package br.com.loccar.dto;

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
	
	public String getNome() {
		return nome;
	}
	
	  
	public void setNome(String nome) {
		this.nome = nome;
	}
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