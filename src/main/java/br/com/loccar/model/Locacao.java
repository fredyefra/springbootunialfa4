package br.com.loccar.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Locacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer identificador;
	private Cliente cliente;
	private Veiculo veiculo;

	public Locacao() {

	}

	public Locacao(Integer identificador, Cliente cliente, Veiculo veiculo) {

		this.identificador = identificador;
		this.cliente = cliente;
	    this.veiculo = veiculo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	@ManyToOne
	@JoinColumn(name = "fkCliente", nullable = false)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
	@ManyToOne
	@JoinColumn(name = "fkVeiculo", nullable = false)
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
