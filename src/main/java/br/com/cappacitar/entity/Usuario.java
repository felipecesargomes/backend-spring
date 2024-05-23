package br.com.cappacitar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario extends Base {

	@NotNull
	@Column(unique = true, name = "login", nullable = false)
	private String username;
	@NotNull
	@Column(name = "senha", nullable = false)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
