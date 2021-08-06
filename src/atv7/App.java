package atv7;

import java.util.Scanner;

import controllers.PessoaFisicaController;

public class App {
    public static void main(String[] args) {

		var menu = 0;
		var input = new Scanner(System.in);

        var pessoaFisicaController = new PessoaFisicaController();
		var pessoaJuridicaController = new PessoaJuridicaController();
		var estadoController = new EstadoController();
		var cidadeController = new CidadeController();

		do {
			System.out.println("Digite o valor de uma das açõees a seguir:\n");
			System.out.println("(1) - Pessoa Física");
			System.out.println("(2) - Pessoa Jurídica");
			System.out.println("(3) - Estádo");
			System.out.println("(4) - Cidade");
			System.out.println("(0) - Sair");

			menu = Integer.parseInt(input.next());

			switch(menu) {
				case 0:
					break;
				case 1:
					pessoaFisicaController.menu();
					break;
				case 2:
					pessoaJuridicaController.menu();
					break;
				case 3:
					estadoController.menu();
					break;
				case 4:
					cidadeController.menu();
					break;
				default:
					System.out.println("\nOpção inválida!\n");
					break;
			}

		} while(menu != 0);
		
		input.close();
	}
}
