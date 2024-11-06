package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		int opcao;

		while (true) {

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

			opcao = leitor.nextInt();

			if (opcao == 9) {
				
				System.out.println("\n BANCO BRADESCO - O seu futuro começa aqui!");
				sobre ();
				leitor.close();
				System.exit(0);

			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				break;
			case 2:
				System.out.println("Listar Todas as Contas\n\n");

				break;
			case 3:
				System.out.println("Buscar Conta por Numero\n\n");

				break;
			case 4:
				System.out.println("Atualizar Dados da Conta\n\n");

				break;
			case 5:
				System.out.println("Apagar Conta\n\n");

				break;
			case 6:
				System.out.println("Sacar\n\n");

				break;
			case 7:
				System.out.println("Depositar\n\n");

				break;
			case 8:
				System.out.println("Transferir Valores entre Contas\n\n");

				break;
			default:
				System.out.println("opção invalida\n\n");

				break;

			}

		}

	}

	public static void sobre() {
		System.out.println("\n*****************************************************");
		System.out.println("Projeto Desenvolvido por: Dandara Medeiros Da Silva");
		System.out.println("Generation Brasil - dandaraS@genenation.org");
		System.out.println("https://github.com/DandaraaAfroo");
		System.out.println("*******************************************************");
	}
}