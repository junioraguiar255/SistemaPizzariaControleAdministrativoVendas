package br.pizza.ModeloBeans;

/**
 * 
 * @author JOSEMAR JUNIOR
 * 
 */

public class Gerente extends Funcionario implements Autentificavel {

	public Gerente(String nome, int cpf, int registro) {
		super(nome, cpf, registro);

	}

	@Override
	public void criaLogin() {

	}

	@Override
	public void esqueceuSenha() {

	}

}
