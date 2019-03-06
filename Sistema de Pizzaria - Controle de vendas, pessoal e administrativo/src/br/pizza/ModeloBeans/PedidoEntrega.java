package br.pizza.ModeloBeans;

/**
 * 
 * @author JOSEMAR JUNIOR
 * 
 */

public class PedidoEntrega extends Pedido {

	private double taxa_entrega;

	public PedidoEntrega(Cliente cliente, Funcionario atendente, int id, Motoboy entregador) {
		super(cliente, atendente, id);
		this.setTaxa_entrega(3);
		this.setValor(getValor() + getTaxa_entrega());
		this.setEntregador(entregador);
	}

	@Override
	public String toString() {
		return "IDENTIFICAÇÃO DO PEDIDO: \nID: " + getIdPedido() + " Nome do Cliente: " + this.getCliente().getNome()
				+ this.getCliente().exibeEnderecos() + ", Nome do atendente: " + getAtendente().getNome()
				+ ", Nome do MOTOBOY: " + this.getEntregador().getNome() + ", Valor do serviço= " + getValor() + "]"
				+ "\n=================================";

	}

	public double getTaxa_entrega() {
		return taxa_entrega;
	}

	public void setTaxa_entrega(double taxa_entrega) {
		this.taxa_entrega = taxa_entrega;
	}
}
