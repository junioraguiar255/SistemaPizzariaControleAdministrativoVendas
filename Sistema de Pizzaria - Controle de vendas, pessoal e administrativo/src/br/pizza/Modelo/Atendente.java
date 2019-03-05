package br.pizza.Modelo;


public class Atendente extends Funcionario implements Autentificavel {
	private int ramal;

	public Atendente(String nome, int cpf, int registro, int ramal) {
		super(nome, cpf, registro);
		this.ramal = ramal;
	}

	@Override
	public String toString() {
		return "Atendente :" + getNome();
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	@Override
	public void criaLogin() {
		
		
	}

	@Override
	public void esqueceuSenha() {
		
		
	};

}

