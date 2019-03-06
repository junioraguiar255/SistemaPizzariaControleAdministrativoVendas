package br.pizza.ModeloBeans;

/**
 * 
 * @author JOSEMAR JUNIOR
 * 
 */

public abstract class Funcionario extends Pessoa {

	private int registro;
	private String login;
	private String senha;
	private boolean ativo;

	public Funcionario(String nome, int cpf, int registro) {
		super(nome, cpf);
		this.registro = registro;
		this.ativo = true;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
