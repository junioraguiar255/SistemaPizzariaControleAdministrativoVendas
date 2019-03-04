package br.pizza.telas;

public class Motoboy extends Funcionario {
	private String moto_placa;

	public Motoboy(String nome, int cpf, int registro, String moto_placa) {
		super(nome, cpf, registro);
		this.moto_placa = moto_placa;
	}

	public String getMoto_placa() {
		return moto_placa;
	}

	public void setMoto_placa(String moto_placa) {
		this.moto_placa = moto_placa;
	}

}
