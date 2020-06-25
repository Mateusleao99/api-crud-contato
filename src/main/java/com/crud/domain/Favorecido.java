package com.crud.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Favorecido {
	
	@Id
	private String cpf;
	
	@Column (name="nome")
	private String nome;
	
	@Column (name="sobrenome")
	private String sobrenome;
	
	@Column (name="data_nascimento")
	private LocalDateTime dataNascimento;
	
	@OneToMany(mappedBy = "favorecido" , cascade = CascadeType.ALL)
	private List<Conta> contas;
	
	public Favorecido() {
		
	}
	
	public Favorecido(String cpf, String nome, String sobrenome, LocalDateTime dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
