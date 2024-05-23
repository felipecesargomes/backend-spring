package br.com.cappacitar.entity;


public enum StatusLancamento {

	S("S"), N("N");

	private String label;

	private StatusLancamento(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}