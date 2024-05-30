package br.com.cappacitar.DTO;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import br.com.cappacitar.entity.PlanoConta;
import br.com.cappacitar.entity.TipoTransacao;
import io.swagger.v3.oas.annotations.Hidden;

public class TipoLancamentoDTO extends BaseDTO {

	private String descricao;
	private PlanoConta planoConta;
	private char sistema;
	private TipoTransacao tipoTransacao;

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

	// Getter para obter a descrição concatenada com "+" ou "-"

		@Hidden
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
		this.sistema = sistema;
	}



}
