package br.pizza.telas;


public class Endereco {
	private String rua;
	private int numero;
	private String referencia;

	public Endereco(String rua, int numero, String referencia) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.referencia = referencia;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}

