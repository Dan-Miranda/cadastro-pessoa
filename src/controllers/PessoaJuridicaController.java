package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import classes.PessoaJuridica;
import repositories.PessoaJuridicaRepository;

public class PessoaJuridicaController {

	public PessoaJuridicaController() {}

	public void menu() {

		var menu = 0;
		var input = new Scanner(System.in);

		do {
			System.out.println("\nPESSOA JURÍDICA\n");
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
		System.out.println("Inserir - PESSOA JURÍDICA\n");
        
        var pessoaJuridica = new PessoaJuridica();
        
        pessoaJuridica = pessoaJuridica.colherDadosPessoaJuridica();

        var pessoaJuridicaRepository = new PessoaJuridicaRepository();
        pessoaJuridicaRepository.inserir(pessoaJuridica);
	}

	private void listar() {
        var pessoaJuridicaRepository = new PessoaJuridicaRepository();
        var pessoasJuridicas = pessoaJuridicaRepository.listar();

        pessoasJuridicas.forEach(pj -> {
            System.out.println("Id: " + pj.getId());
            System.out.println("Nome Social: " + pj.getNomeSocial());
            System.out.println("RazaoSocial: " + pj.getRazaoSocial());
            System.out.println("CNPJ: " + pj.getCnpj());
            System.out.println("Inscrição Estadual: " + pj.getInscricaoEstadual());
            System.out.println("Inscrição Municipal: " + pj.getInscricaoMunicipal());
            System.out.println("FAX: " + pj.getFax());
            System.out.println("Website: " + pj.getWebSite());
            System.out.println("Email: " + pj.getEmail());
            System.out.println("Telefone: " + pj.getTelefone());
            System.out.println("Rua: " + pj.getRua());
            System.out.println("Número: " + pj.getNumero());
            System.out.println("Complemento: " + pj.getComplemento());
            System.out.println("Bairro: " + pj.getBairro());
            System.out.println("CEP: " + pj.getCep());
            
            var estadoController = new EstadoController();

            estadoController.listar().forEach(estado -> {
                if (estado.getId() == pj.getEstadoId()) {
                    System.out.println("Estado: " + estado.getNome() + " - " + estado.getSigla());
                }
            });

            var cidadeController = new CidadeController();

            cidadeController.listar().forEach(cidade -> {
                if (cidade.getId() == pj.getCidadeId()) {
                    System.out.println("Cidade: " + cidade.getNome());
                }
            });
        });
	}
}
