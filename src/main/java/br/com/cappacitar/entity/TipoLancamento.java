package br.com.cappacitar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "t_tipo_lancamento")
public class TipoLancamento extends Base {

	@NotEmpty
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "idplanoconta", nullable = false)
	private PlanoConta planoConta;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipotransacao", length = 50)
	private TipoTransacao tipoTransacao;

	@Column(name = "sistema")
	private char sistema;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

//	@Hidden
	public String getTipo() {
		if (this.tipoTransacao == TipoTransacao.RECEITA) {
			return "[+] " + this.descricao;
		} else {
			return "[-] " + this.descricao;
		}
	}

	public char getSistema() {
		return sistema;
	}

	public void setSistema(char sistema) {
		this.sistema = 'N';
	}

}