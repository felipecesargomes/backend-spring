package br.com.cappacitar.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.cappacitar.entity.Cnpj;
import br.com.cappacitar.entity.TipoLancamento;

public class LancamentoDTO extends BaseDTO {

	@NotNull
	private TipoLancamento tipoLancamento;
	@NotNull
	private Cnpj cnpj;

	private String descricaoLancamento;
	@NotNull
	@Positive
	private BigDecimal valor;

	@NotNull
	@Column(name = "datalancamento", nullable = false)
	private LocalDate dataLancamento;

	@NotNull
	@Column(name = "status", nullable = false)
	private char status = 'N';

	public Cnpj getCnpj() {
		return cnpj;
	}

	public void setCnpj(Cnpj cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) throws Exception {
		if (status == 'N' || status == 'S') {
			this.status = status;
		} else {
			throw new Exception();
			//throw new IllegalArgumentException("O valor de confirmado deve ser 'N' ou 'S'");
		}
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

}
