package br.pizza.telas;


public abstract class Pessoa {
	private String nome;
	private int cpf;

	public Pessoa(String nome, int cpf) {

		this.nome = nome;
		this.cpf = cpf;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
