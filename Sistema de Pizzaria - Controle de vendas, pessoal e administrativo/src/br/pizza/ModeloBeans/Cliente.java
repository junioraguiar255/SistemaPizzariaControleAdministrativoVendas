package br.pizza.ModeloBeans;

import java.util.ArrayList;

/**
 * 
 * @author JOSEMAR JUNIOR
 * 
 */

public class Cliente extends Pessoa {
	private int telefone;

	ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	ArrayList<Pedido> pedidosEncerrados = new ArrayList<Pedido>();

	public Cliente(String nome, int cpf, int telefone) {
		super(nome, cpf);
		this.telefone = telefone;
	}

	public ArrayList<Pedido> getPedidosEncerrados() {
		return pedidosEncerrados;
	}

	public void setPedidosEncerrados(ArrayList<Pedido> pedidosEncerrados) {
		this.pedidosEncerrados = pedidosEncerrados;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [Nome=" + getNome() + ",\n Cpf=" + getCpf() + ",\n telefone" + telefone + "\n]";
	}

	public void exibeHistorico() {
		float x = 0;
		float p = 0;
		if (pedidosEncerrados.isEmpty() == false) {
			System.out.println("Pedidos encerrados do cliente: " + this.getNome());
			for (Pedido c : pedidosEncerrados) {
				System.out.println("=====================");
				System.out.println("ID do pedido: " + c.getIdPedido());
				System.out.println("Valor do serviço: " + c.getValor());
				x += c.getValor();
			}
		}
		if (pedidos.isEmpty() == false) {
			System.out.println("Pedidos abertos do cliente: " + this.getNome());
			for (Pedido c : pedidos) {
				System.out.println("=====================");
				System.out.println("ID do pedido: " + c.getIdPedido());
				System.out.println("Valor do serviço: " + c.getValor());
				p += c.getValor();
			}
		}
		System.out.println("=====================");
		System.out.println("HISTORICO FINANCEIRO - " + this.getNome());
		System.out.println("Total de valores encerrados R$:" + x);
		System.out.println("Total de valores abertos R$:" + p);
		System.out.println("Total R$:" + (p + x));
	}

	public String exibeEnderecos() {

		if (enderecos.isEmpty() == false) {
			System.out.println("Enderecos do cliente: " + this.getNome());
			int x = 1;
			for (Endereco c : enderecos) {
				System.out.println("=====================");
				System.out.println(x + "- Nome da Rua do Cliente: " + c.getRua());
				System.out.println(x + "- Numero da casa: " + c.getNumero());
				System.out.println(x + "- Ponto de referência: " + c.getReferencia());
				x++;
			}
		}
		return "";
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	public void adicionarPedido(Pedido r) {
		pedidos.add(r);
	}

	public void adicionarEndereco(Endereco r) {
		enderecos.add(r);
	}

	public void removePedido(Pedido r) {
		pedidos.remove(r);
	}

	public void adicionarPedidoEncerrado(Pedido r) {
		pedidosEncerrados.add(r);
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
