package controllers;

import java.util.List;
import java.util.Scanner;

import classes.Cidade;
import repositories.CidadeRepository;

public class CidadeController {
    public CidadeController() {}

    public void menu() {
		var menu = 0;
		var input = new Scanner(System.in);
		
        do {
			System.out.println("\CIDADE\n");
			System.out.println("Digite o valor de uma das ações abaixo:\n");
			System.out.println("(1) - Inserir");
			System.out.println("(2) - Listar");
			System.out.println("(0) - Voltar ao menu anterior");

			menu = Integer.parseInt(input.nextLine());

			switch(menu) {
				case 1:
					this.inserir();
					break;
				case 2:
					this.listar();
					break;
				default:
					break;
			}
		} while(menu != 0);
	}

    public void inserir(Scanner input) {
        var cidadeRepository = new CidadeRepository();
        var cidade = new Cidade();
        cidade = cidade.colherDados(input);
        cidadeRepository.inserir(cidade);
    }

    public List<Cidade> listar() {
        var cidadeRepository = new CidadeRepository();
        return cidadeRepository.listar();
    }
}
