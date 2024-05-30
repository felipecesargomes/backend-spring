package br.com.cappacitar.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity(name = "t_lancamento")
public class Lancamento extends Base {
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idtipolancamento", nullable = false)
	private TipoLancamento tipoLancamento;

	@Column(name = "descricaolancamento", nullable = true, length = 255)
	private String descricaoLancamento;

	@NotNull
	@Positive
	@Column(name = "valor", nullable = false, precision = 16, scale = 2)
	private BigDecimal valor;

	@NotNull
	@Column(name = "datalancamento", nullable = false)
	private LocalDate dataLancamento;

	@NotNull
	@Column(name = "status", nullable = false)
	private char status = 'N';

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idcnpj", nullable = false)
	private Cnpj cnpj;

	@Column(name = "datacadastro", nullable = true)
	private LocalDate dataCadastro;

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
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
		}
	}

	public Cnpj getCnpj() {
		return cnpj;
	}

	public void setCnpj(Cnpj cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	@PrePersist
	public void prePersist() {
		this.dataCadastro = LocalDate.now();
	}

}