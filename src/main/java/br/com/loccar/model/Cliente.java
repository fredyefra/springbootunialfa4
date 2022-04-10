package br.com.loccar.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Cliente implements Serializable  {

	private static final long serialVersionUID = 1L;

	private Integer identificador;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
    private StatusPagamento statusPagamento; 
	private String dtCadastro;
    
    private List<Locacao> locacaos = new ArrayList<Locacao>();

	public Cliente() {

	}

	public Cliente(Integer identificador, String nome, String endereco, String telefone, String email) {
		this.identificador = identificador;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
         
	}

	  public Cliente( String nome, String endereco, String telefone, String email){ 
		  this.nome = nome; 
		  this.endereco = endereco; 
		  this.telefone = telefone;
	      this.email = email; 
	}
	 
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	@NotBlank //(message = "Campo obrigatório!")
	@NotNull (message = "Campo obrigatório!")
	@Length(min = 3, max = 100, message = "O Campo deve ter entre 3 e 50 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotBlank (message = "Campo obrigatório!")
	@NotNull (message = "Campo obrigatório!")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
	@NotBlank (message = "Campo obrigatório!")
	@NotNull (message = "Campo obrigatório!")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	public List<Locacao> getLocacaos() {
		return locacaos;
	}

	public void setLocacaos(List<Locacao> locacaos) {
		this.locacaos = locacaos;
	}

	@NotBlank (message = "Campo obrigatório!")
	@NotNull (message = "Campo obrigatório!")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//@Enumerated(EnumType.STRING)
	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(String dtCadastro) {
		this.dtCadastro = dataFormatada();
	}

	private String dataFormatada() {
		LocalDate dtCadastro = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String hojeFormatado = dtCadastro.format(formatter);
		return  hojeFormatado;

	}
    
	@Override
	public String toString() {
		return "Cliente [identificador=" + identificador + ", nome=" + nome + ", endereco=" + endereco + ", telefone="
				+ telefone + ", email=" + email + ", statusPagamento=" + statusPagamento + ", dtCadastro=" + dtCadastro +"]";
	}
}