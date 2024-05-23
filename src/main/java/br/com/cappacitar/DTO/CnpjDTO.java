package br.com.cappacitar.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Cnpj DTO")
public class CnpjDTO extends BaseDTO {

	private String nome;
	private String cidade;
	private String cnpj;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Hidden
	public String getLabel() {
		return this.getCnpj() + " - " + this.getNome();
	}


}
