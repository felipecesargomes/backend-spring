package br.com.cappacitar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "t_cnpj")
public class Cnpj extends Base {

	@NotEmpty
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@NotEmpty
	@Column(name = "cidade", nullable = false, length = 255)
	private String cidade;

	@NotEmpty
	@Column(name = "cnpj", nullable = false, length = 14)
	private String cnpj;

//	@Hidden
//	@Schema(hidden = true) //Esconder na documentação da API
//	private String senha;

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