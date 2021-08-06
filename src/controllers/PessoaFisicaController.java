package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import classes.PessoaFisica;
import repositories.PessoaFisicaRepository;

public class PessoaFisicaController {

	public PessoaFisicaController() {}

	public void menu() {
		var menu = 0;
		var input = new Scanner(System.in);
		
        do {
			System.out.println("\nPESSOA FÍSICA\n");
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

	private void inserir() {
		System.out.println("Inserir - PESSOA FÍSICA\n");

        var pessoaFisica = new PessoaFisica();
        pessoaFisica = pessoaFisica.colherDadosPessoaFisica();
        
        var pessoaFisicaRepository = new PessoaFisicaRepository();
        pessoaFisicaRepository.inserir(pessoaFisica);
	}

	private void listar() {
        var pessoaFisicaRepository = new PessoaFisicaRepository();
        var pessoasFisicas = pessoaFisicaRepository.listar();

        pessoasFisicas.forEach(pf -> {
            System.out.println("Id: " + pf.getId());
            System.out.println("Nome Social: " + pf.getNomeSocial());
            System.out.println("RazaoSocial: " + pf.getRazaoSocial());
            System.out.println("CPF: " + pf.getCpf());
            System.out.println("RG: " + pf.getRg());

            var formatoData = new SimpleDateFormat("dd/MM/yyyy");
            var dataNascimento = "";

            try {
                dataNascimento = formatoData.parse(pf.getDataNascimento()).toString();
            } catch (ParseException e) {
               dataNascimento = pf.getDataNascimento();
            }

            System.out.println("Data de Nascimento: " + dataNascimento);

            System.out.println("Email: " + pf.getEmail());
            System.out.println("Telefone: " + pf.getTelefone());
            System.out.println("Rua: " + pf.getRua());
            System.out.println("Número: " + pf.getNumero());
            System.out.println("Complemento: " + pf.getComplemento());
            System.out.println("Bairro: " + pf.getBairro());
            System.out.println("CEP: " + pf.getCep());

            var estadoController = new EstadoController();
            
            estadoController.listar().forEach(estado -> {
                if (estado.getId() == pf.getEstadoId()) {
                    System.out.println("Estado: " + estado.getNome() + " - " + estado.getSigla());
                }
            });

            var cidadeController = new CidadeController();
            
            cidadeController.listar().forEach(cidade -> {
                if (cidade.getId() == pf.getCidadeId()) {
                    System.out.println("Cidade: " + cidade.getNome());
                }
            });
        });
	}
}
