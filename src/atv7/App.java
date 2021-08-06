package atv7;

import java.util.Scanner;

import controllers.PessoaFisicaController;

public class App {
    public static void main(String[] args) {

		var menu = 0;
		var input = new Scanner(System.in);

        var pessoaFisicaController = new PessoaFisicaController();
		var pessoaJuridicaController = new PessoaJuridicaController();

		do {
			System.out.println("Digite o valor de uma das açõees a seguir:\n");
			System.out.println("(1) - Pessoa Física");
			System.out.println("(2) - Pessoa Jurídica");
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
				default:
					System.out.println("\nOpção inválida!\n");
					break;
			}

		} while(menu != 0);
		input.close();
	}

}
