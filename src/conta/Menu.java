package conta;

import java.io.IOException;
import java.util.InputMismatchException;

import java.util.Scanner;
import conta.Util.Cores;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leitor = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Maria dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);

			System.out.println("***************************************************************************");
			System.out.println("                                                                           ");
			System.out.println("                            BANDO BRADESCO                                 ");
			System.out.println("***************************************************************************");
			System.out.println("                                                                           ");
			System.out.println("                        1 - Criar Conta                                    ");
			System.out.println("                        2 - Listar Todas as Contas                         ");
			System.out.println("                        3 - Buscar Conta por Numero                        ");
			System.out.println("                        4 - Atualizar Dados da Conta                       ");
			System.out.println("                        5 - Apagar Conta                                   ");
			System.out.println("                        6 - Sacar                                          ");
			System.out.println("                        7 - Depositar                                      ");
			System.out.println("                        8 - Transferir valores entre Contas                ");
			System.out.println("                        9 - Sair                                           ");
			System.out.println("                                                                           ");
			System.out.println("***************************************************************************");
			System.out.println("Entre com a opção desejada:                                                ");
			System.out.println("                                                                           ");

			try {
				opcao = leitor.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leitor.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {

				System.out.println(" BANCO BRADESCO - O seu futuro começa aqui! ");
				sobre();
				leitor.close();
				System.exit(0);

			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				System.out.println("Digite o Número da Agência: ");
				agencia = leitor.nextInt();

				System.out.println("Digite o Nome do Titular: ");
				leitor.skip("\\R?");
				titular = leitor.nextLine();

				do {

					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = leitor.nextInt();
				} while (tipo < 1 || tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leitor.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = leitor.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leitor.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}

				}
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar Todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar Conta por Numero\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leitor.nextInt();

				contas.procuraPorNome(numero);

				keyPress();

			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Dados da Conta\n\n");

				System.out.print("Digite o número da conta: ");
				numero = leitor.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.print("Digite o Número da Agência: ");
					agencia = leitor.nextInt();
					System.out.println("Digite o Nome do Titular");
					leitor.skip("\\R?");
					titular = leitor.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leitor.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.print("Digite o Limite de Crédito (R$): ");
						limite = leitor.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = leitor.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}

					}
				} else {

					System.out.println("A Conta não foi encontrada!");
				}

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leitor.nextInt();

				contas.deletar(numero);

				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_WHITE + "Sacar\n\n");

				System.out.print("Digite o Número da conta: ");
				numero = leitor.nextInt();

				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leitor.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depositar\n\n");

				System.out.println("Digite o Número da conta; ");
				numero = leitor.nextInt();

				do {
					System.out.println("Digite o valor do Depósito (R$): ");
					valor = leitor.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferir Valores entre Contas\n\n");

				System.out.println("Digite o Número da Conta de origem: ");
				numero = leitor.nextInt();
				System.out.print("\nDigite o Número da Conta de Destino: ");
				numeroDestino = leitor.nextInt();

				do {
					System.out.println("\nDigite o Valor da Transferência (R$): ");
					valor = leitor.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\n opção invalida\n\n");

				break;

			}

		}

	}

	public static void sobre() {
		System.out.println("\n*****************************************************");
		System.out.println("  Projeto Desenvolvido por: Dandara Medeiros Da Silva  ");
		System.out.println("      Generation Brasil - dandaraS@genenation.org      ");
		System.out.println("          https://github.com/DandaraaAfroo             ");
		System.out.println("*******************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\n Pressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}