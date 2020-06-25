package com.crud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long agencia;
	
	private Long conta;
	
	private Long digito;
	
	@ManyToOne
	private Favorecido favorecido;
	
	public Long getAgencia() {
		return agencia;
	}
	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}
	public Long getConta() {
		return conta;
	}
	public void setConta(Long conta) {
		this.conta = conta;
	}
	public Long getDigito() {
		return digito;
	}
	public void setDigito(Long digito) {
		this.digito = digito;
	}
	public Favorecido getFavorecido() {
		return favorecido;
	}
	
}
