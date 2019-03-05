package br.pizza.Modelo;


import java.util.Date;

public class Pedido {
	private Cliente cliente;
	private Funcionario atendente;
	private double desconto;
	private double valor;
	private Date data;
	private Date hora;
	private int idPedido;
	private Motoboy entregador;

	public Funcionario getEntregador() {
		return entregador;
	}

	public void setEntregador(Motoboy entregador) {
		this.entregador = entregador;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Pedido(Cliente cliente, Funcionario atendente, int id) {

		this.cliente = cliente;
		this.atendente = atendente;
		this.valor = 10;
		this.idPedido = id;
	}

	@Override
	public String toString() {
		return "\nID: " + getIdPedido() + ",\n Pedido [  " + getCliente() + ",\n Atendente= " + getAtendente()
				+ ",\n Valor do serviço= " + getValor() + "]";

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getAtendente() {
		return atendente;
	}

	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}



}
