package br.com.cappacitar.DTO;

public class PlanoContaDTO extends BaseDTO {

	private String contaGerencial;
	private String descricao;

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

}
