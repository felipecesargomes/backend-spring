package br.com.cappacitar.entity;


public enum TipoTransacao {

	RECEITA("RECEITA"), DESPESA("DESPESA");

	private String label;

	private TipoTransacao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}