package br.pizza.ModeloBeans;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	/**
	 * CLASSE PARA REALIZAR TESTES NO CONSOLE E JÁ SIMULANDO O FUNCIONAMENTO DO
	 * SISTEMA
	 * 
	 * @author JOSEMAR JUNIOR
	 * 
	 */

	static Scanner input = new Scanner(System.in);

	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	static int ped = 2;

	public static void main(String[] args) {
		int opc = 0;

		Cliente x = new Cliente("Josemar", 1, 333999);
		Endereco z = new Endereco("Rua do Trilho velho", 1601, "Prox ao bar da maroca");
		Endereco v = new Endereco("Rua Rio branco", 1000, "Prox a otica Diniz");
		Motoboy k = new Motoboy("João", 2, 1, "35h");
		Atendente a = new Atendente("Maria", 3, 2, 3569);
		Pedido u = new Pedido(x, a, 1);
		x.adicionarEndereco(z);
		x.adicionarEndereco(v);
		clientes.add(x);
		funcionarios.add(k);
		funcionarios.add(a);
		x.adicionarPedido(u);
		do {
			System.out.println("\n*** MENU ***");
			System.out.println("1 - Cadastro de Cliente");
			System.out.println("2 - Controle de Funcionarios");
			System.out.println("3 - Exibir dados cliente");
			System.out.println("4 - Cadastrar Pedido");
			System.out.println("5 - Exibir Pedidos abertos");
			System.out.println("6 - Exibir pedidos fechados");
			System.out.println("7 - Fechar pedidos");
			System.out.println("8 - Exibir pedidos para entrega");
			System.out.println("9 - Relatórios financeiros");
			System.out.println("0 - Sair");

			boolean result = true;
			do {
				try {
					opc = Integer.parseInt(input.nextLine());
					result = false;
				} catch (NumberFormatException e2) {
					System.out.print("Dado invalido - tente novamente - Digite sua opção.\n");

				}
			} while (result);

			switch (opc) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				cadastrarFuncionario();
				break;
			case 3:
				exibirDadosCliente();
				break;
			case 4:
				cadastrarPedido();
				break;
			case 5:
				exibirPedidosabertos();
				break;
			case 6:
				exibirPedidosfechados();
				break;
			case 7:
				fecharPedidos();
				break;
			case 8:
				exibirPedidoEntrega();
				break;
			case 9:
				relatorioFinanceiro();
				break;
			default:
				break;
			}
		} while (opc != 0);

	}

	private static void cadastrarCliente() {
		int opc = 0;
		System.out.println("Digite o nome do cliente:");
		String nome = input.nextLine();
		System.out.println("Digite o cpf do cliente:");
		int cpf = Integer.parseInt(input.nextLine());
		System.out.println("Digite o telefone do cliente:");
		int telefone = Integer.parseInt(input.nextLine());
		Cliente cli = new Cliente(nome, cpf, telefone);
		System.out.println("Digite o nome da rua do cliente:");
		String rua = input.nextLine();
		System.out.println("Digite o numero da casa cliente:");
		int numero = Integer.parseInt(input.nextLine());
		System.out.println("Escreva algum ponto de referência:");
		String ref = input.nextLine();
		Endereco c = new Endereco(rua, numero, ref);
		cli.adicionarEndereco(c);
		do {
			System.out.println("Digite 1 para adicionar um novo endereço");
			System.out.println("Digite 0 para Terminar");
			opc = Integer.parseInt(input.nextLine());

			switch (opc) {
			case 1:
				Endereco a = cadastraEndereco();
				cli.adicionarEndereco(a);
				break;

			default:
				break;
			}
		} while (opc != 0);

		clientes.add(cli);
		System.out.println("Cliente cadastrado.");
	}

	public static Endereco cadastraEndereco() {

		System.out.println("Digite o nome da rua do cliente:");
		String rua = input.nextLine();
		System.out.println("Digite o numero da casa cliente:");
		int numero = Integer.parseInt(input.nextLine());
		System.out.println("Escreva algum ponto de referência:");
		String ref = input.nextLine();
		Endereco c = new Endereco(rua, numero, ref);
		return c;
	}

	private static void cadastrarFuncionario() {
		int op = 0;
		System.out.println("1 - Cadastrar Atendente");
		System.out.println("2 - Cadastrar MotoBoy");
		System.out.println("3 - Cadastrar Gerente");
		System.out.println("4 - Afastar funcionários");
		System.out.println("5 - Venda por Atendente");
		System.out.println("6 - Venda por MotoBy");
		System.out.println("7 - Ativar funcionários");
		System.out.println("0 - VOLTAR");
		op = Integer.parseInt(input.nextLine());

		switch (op) {
		case 1:
			cadastrarAtendente();
			break;
		case 2:
			cadastrarMotoboy();
			break;
		case 3:
			cadastrarGerente();
			break;
		case 4:
			afastaFuncionario();
			break;
		case 5:
			vendaPorAtendente();
			break;
		case 6:
			vendaPorMotoBoy();
			break;
		case 7:
			ativaFuncionario();
			break;
		case 0:
			return;
		default:
			break;
		}
	}

	private static void vendaPorAtendente() {
		System.out.println("Digite o registro do funcionário:");
		float x = 0, y = 0;
		int reg = Integer.parseInt(input.nextLine());
		for (Funcionario f : funcionarios) {
			if (f.getRegistro() == reg) {
				if (!(f instanceof Atendente)) {
					System.out.println("Funcionario de registro: " + reg + " Não é um atendente - Tente novamente");
					return;
				}

				for (Cliente c : clientes) {
					for (Pedido pedi : c.getPedidos()) {
						if (pedi.getAtendente().getRegistro() == reg) {
							x += pedi.getValor();
						}
					}
				}

				for (Cliente c : clientes) {
					for (Pedido pedi : c.getPedidosEncerrados()) {
						if (pedi.getAtendente().getRegistro() == reg) {
							y += pedi.getValor();
						}
					}
				}
				System.out.println("O(a) funcionario: " + f.getNome() + " Tem R$: " + x + " Valores abertos e R$: " + y
						+ " Valores fechados , totalizando: R$: " + (x + y));
				return;
			}

		}
		System.out.println("Funcionario não encontrado - Tente novamente");
	}

	private static void vendaPorMotoBoy() {
		System.out.println("Digite o registro do funcionário:");
		float x = 0, y = 0;
		int reg = Integer.parseInt(input.nextLine());
		for (Funcionario f : funcionarios) {
			if (f.getRegistro() == reg) {
				if (!(f instanceof Motoboy)) {
					System.out.println("Funcionario de registro: " + reg + " Não é um Motoboy - Tente novamente");
					return;
				}

				for (Cliente c : clientes) {
					for (Pedido pedi : c.getPedidos()) {
						if (!(pedi instanceof PedidoEntrega)) {
							continue;
						}
						if (pedi.getEntregador().getRegistro() == reg) {
							x += pedi.getValor();
						}
					}
				}

				for (Cliente c : clientes) {
					for (Pedido pedi : c.getPedidosEncerrados()) {
						if (pedi.getEntregador().getRegistro() == reg) {
							y += pedi.getValor();
						}
					}
				}
				System.out.println("O (a) funcionario: " + f.getNome() + " Tem R$: " + x + " Valores abertos e R$: " + y
						+ " Valores fechados , totalizando: R$: " + (x + y));
				return;
			}

		}
		System.out.println("Funcionario não encontrado - Tente novamente");
	}

	private static void ativaFuncionario() {
		System.out.println("Digite o registro do funcionário a ser reativado:");
		int reg = Integer.parseInt(input.nextLine());
		for (Funcionario c : funcionarios) {
			if (c.getRegistro() == reg) {
				if (c.getAtivo() == true) {
					System.out.println("Funcionario de Registro: " + reg + " Já estava ativo do sistema");
					return;
				}
				System.out.println(
						"Tem certeza que deseja reativar: " + c.getNome() + " ?(1 para sim ou outro valor para não)");
				int op = Integer.parseInt(input.nextLine());
				if (op == 1) {
					System.out.println("Funcionário reativado com sucesso");
					c.setAtivo(true);
				}
				return;
			}

		}

	}

	private static void afastaFuncionario() {
		System.out.println("Digite o registro do funcionário a ser afastado:");
		int reg = Integer.parseInt(input.nextLine());
		for (Funcionario c : funcionarios) {
			if (c.getRegistro() == reg) {
				if (c.getAtivo() == false) {
					System.out.println("Funcionario de Registro: " + reg + " Já estava afastado do sistema");
					return;
				}
				System.out.println(
						"Tem certeza que deseja afastar: " + c.getNome() + " ?(1 para sim ou outro valor para não)");
				int op = Integer.parseInt(input.nextLine());
				if (op == 1) {
					System.out.println("Funcionário afastado com sucesso");
					c.setAtivo(false);
				}
				return;
			}

		}

	}

	private static void relatorioFinanceiro() {
		int op = 0;
		System.out.println("1 - Total de pagamento em aberto ");
		System.out.println("2 - Total de pagamento fechados");
		System.out.println("3 - Exibir total de pagamentos");
		System.out.println("4 - Venda por Atendente");
		System.out.println("5 - Venda por MotoBy");
		System.out.println("0 - VOLTAR");
		op = Integer.parseInt(input.nextLine());

		switch (op) {
		case 1:
			totalPagamentoAberto();
			break;
		case 2:
			totalPagamentoFechado();
			break;
		case 3:
			totalPagamentos();
			break;
		case 4:
			vendaPorAtendente();
			break;
		case 5:
			vendaPorMotoBoy();
			break;
		case 0:
			return;
		default:
			break;
		}
	}

	public static void totalPagamentoAberto() {
		float x = 0;
		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidos()) {
				x += pedi.getValor();
			}
		}
		System.out.println("VALORES A SER RECEBIDO É= " + x);
	}

	public static void totalPagamentoFechado() {
		float x = 0;
		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidosEncerrados()) {
				x += pedi.getValor();
			}
		}
		System.out.println("VALORES JA RECEBIDOS É = " + x);
	}

	public static void totalPagamentos() {
		float total = 0;
		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidos()) {
				total += pedi.getValor();
			}
		}
		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidosEncerrados()) {
				total += pedi.getValor();
			}
		}
		System.out.println("TOTAL DE PAGAMENTOS = " + total);

	}

	private static void cadastrarMotoboy() {
		System.out.println("Digite o nome do Motoboy:");
		String nome = input.nextLine();
		System.out.println("Digite o cpf do Motoboy:");
		int cpf = Integer.parseInt(input.nextLine());
		System.out.println("Digite o registro do Motoboy:");
		int registro = Integer.parseInt(input.nextLine());
		System.out.println("Digite a placa do Motoboy:");
		String placa = input.nextLine();

		funcionarios.add(new Motoboy(nome, cpf, registro, placa));
		System.out.println("MotoBoy cadastrado.");
	}

	private static void cadastrarGerente() {
		System.out.println("Digite o nome do Gerente:");
		String nome = input.nextLine();
		System.out.println("Digite o cpf do Gerente:");
		int cpf = Integer.parseInt(input.nextLine());
		System.out.println("Digite o registro do Gerente:");
		int registro = Integer.parseInt(input.nextLine());

		funcionarios.add(new Gerente(nome, cpf, registro));
		System.out.println("Gerente cadastrado.");
	}

	private static void cadastrarAtendente() {
		System.out.println("Digite o nome do Atendente:");
		String nome = input.nextLine();
		System.out.println("Digite o cpf do Atendente:");
		int cpf = Integer.parseInt(input.nextLine());
		System.out.println("Digite o registro do Atendete:");
		int registro = Integer.parseInt(input.nextLine());
		System.out.println("Digite o ramal do Atendete:");
		int ramal = Integer.parseInt(input.nextLine());

		funcionarios.add(new Atendente(nome, cpf, registro, ramal));
		System.out.println("Atendente cadastrado.");
	}

	private static Cliente buscarCliente() {
		System.out.println("Digite o cpf do cliente:");
		int cpf = Integer.parseInt(input.nextLine());
		for (Cliente c : clientes) {
			if (c.getCpf() == cpf) {
				return c;
			}
		}
		return null;
	}

	private static Funcionario buscaAtendente() {
		System.out.println("Digite o registro do Atendente:");
		int reg = Integer.parseInt(input.nextLine());
		for (Funcionario c : funcionarios) {
			if (c.getRegistro() == reg && c instanceof Atendente) {
				return c;
			}
			if (c.getRegistro() == reg && !(c instanceof Atendente)) {
				System.out.println(
						"Funcionario informado não é um atendente - necessita ser um atendente para concluir o pedido");
				return null;
			}
		}
		return null;
	}

	private static Motoboy buscaMotoBoy() {
		System.out.println("Digite o registro do MotoBoy:");
		int reg = Integer.parseInt(input.nextLine());
		for (Funcionario c : funcionarios) {
			if (c.getRegistro() == reg && c instanceof Motoboy) {
				return (Motoboy) c;
			}
			if (c.getRegistro() == reg && !(c instanceof Motoboy)) {
				System.out.println(
						"Funcionario informado não é um MotoBoy - necessita ser um MotoBoy para efetuar a entrega");
				return null;
			}
		}
		return null;
	}

	private static void exibirDadosCliente() {
		Cliente c = buscarCliente();
		if (c == null) {
			System.out.println("Cliente não encontrado.");
		} else {
			System.out.println(c);
			c.exibeHistorico();
			c.exibeEnderecos();
		}
	}

	private static void cadastrarPedido() {
		Cliente c = buscarCliente();
		if (c == null) {
			System.out.println("Cliente não encontrado");
			return;
		} else {
			System.out.println("Cliente:" + c.getNome());
		}
		Funcionario f = buscaAtendente();
		if (f == null) {
			System.out.println("Atendente não encontrado");
			return;
		} else if (f.getAtivo() == false) {

			System.out.println("Funcionário não esta ativo - verifique com o administrador");
			return;
		} else {
			System.out.println("Atendente:" + f.getNome());
		}
		System.out.println("O ID DO PEDIDO SERÁ= " + ped);

		System.out.println("Digite P para pizza sem entrega ou E com entrega");
		String res = input.nextLine();
		if (res.equalsIgnoreCase("P")) {
			Pedido o = new Pedido(c, f, ped);
			ped++;
			c.adicionarPedido(o);
			System.out.println("Pedido do Cliente: " + c.getNome() + " realizado com sucesso");

		} else if (res.equalsIgnoreCase("E")) {
			Motoboy m = buscaMotoBoy();
			if (m == null) {
				System.out.println("MotoBoy não encontrado");
				return;
			} else if (m.getAtivo() == false) {

				System.out.println("Funcionário não esta ativo - verifique com o administrador");
				return;
			} else {
				System.out.println("MotoBoy:" + m.getNome());
			}
			PedidoEntrega o = new PedidoEntrega(c, f, ped, m);
			ped++;
			c.adicionarPedido(o);
			System.out.println("Pedido do Cliente: " + c.getNome() + " Realizado com sucesso");
			System.out.println("Entregador: " + m.getNome());
		} else {
			System.out.println("Problema ao realizar pedido");
			return;
		}

	}

	private static void exibirPedidosabertos() {
		System.out.println("Pedido de pizza:");
		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidos()) {
				System.out.println(pedi);
			}
		}
	}

	private static void exibirPedidosfechados() {
		System.out.println("Pedido de pizza encerrados:");
		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidosEncerrados()) {
				System.out.println(pedi);
			}
		}
	}

	private static void fecharPedidos() {
		System.out.println("FECHAMENTO DE PEDIDOS ENCERRADOS");
		System.out.println("Digite o id do pedido a ser encerrado");
		int fecha = Integer.parseInt(input.nextLine());

		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidos()) {
				if (pedi.getIdPedido() == fecha) {
					c.adicionarPedidoEncerrado(pedi);
					c.removePedido(pedi);
					System.out.println("PEDIDO ENCERRADO COM SUCESSO");
					return;
				}
			}
		}
		System.out.println("ID DO PEDIDO NÃO ENCONTRADO");
	}

	private static void exibirPedidoEntrega() {
		System.out.println("=================================");
		System.out.println("[Pedido de pizza para entrega:");
		for (Cliente c : clientes) {
			for (Pedido pedi : c.getPedidos()) {
				if (pedi instanceof PedidoEntrega)
					System.out.println(pedi);
			}
		}
	}

}
