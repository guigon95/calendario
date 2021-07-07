package com.example.calendario.pessoa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "AGENDA")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgenda;

	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFim;

	private float dias;

	@ManyToOne
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	public Long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public float getDias() {
		return dias;
	}

	public void setDias(float dias) {
		this.dias = dias;
	}

	public Pessoa getPessoas() {
		return pessoa;
	}

	public void setPessoas(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
