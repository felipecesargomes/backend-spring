package br.com.cappacitar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "t_plano_conta")
public class PlanoConta extends Base {

	@NotEmpty
	@Column(name = "contagerencial", nullable = false, length = 255)
	private String contaGerencial;

	@NotEmpty
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;

	@JsonIgnore
	@OneToMany(mappedBy = "planoConta")
	private List<TipoLancamento> tipoLancamentos;

	public String getContaGerencial() {
		return contaGerencial;
	}

	public void setContaGerencial(String contaGerencial) {
		this.contaGerencial = contaGerencial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<TipoLancamento> getTipoLancamentos() {
		return tipoLancamentos;
	}

	public void setTipoLancamentos(List<TipoLancamento> tipoLancamentos) {
		this.tipoLancamentos = tipoLancamentos;
	}

}